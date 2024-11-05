package com.example.lista2

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.lista2.databinding.FragmentLogInBinding

class LogIn : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater)

        arguments?.getString("username")?.let { username ->
            binding.etLogin.text = Editable.Factory.getInstance().newEditable(username)
        }

        arguments?.getString("password")?.let { password ->
            binding.etPassword.text = Editable.Factory.getInstance().newEditable(password)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.etLogin.text.toString()
            val password = binding.etPassword.text.toString()

            val user = UserManager.findUser(username, password)
            if (user != null) {
                val actionLogin = LogInDirections.actionLogInToContent2(username)
                Navigation.findNavController(requireView()).navigate(actionLogin)
            } else {
                binding.exception.visibility = View.VISIBLE
            }
        }

        binding.btnRegister.setOnClickListener {
            val actionRegister = LogInDirections.actionLogInToSignIn()
            Navigation.findNavController(requireView()).navigate(actionRegister)
        }
        return binding.root
    }
}