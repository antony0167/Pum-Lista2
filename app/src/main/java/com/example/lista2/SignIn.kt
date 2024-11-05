package com.example.lista2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.lista2.databinding.FragmentSignInBinding

class SignIn : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater)

        binding.btnRegisterSubmit.setOnClickListener {
            val log = binding.etLogin.text.toString()
            val pass1 = binding.etPassword.text.toString()
            val pass2 = binding.etConfirmPassword.text.toString()

            Log.d("First", "I'm here")

            if ( UserManager.checkUsername(log) ) {
                Log.d("Second", "I'm here")
                binding.exception.text = "Nazwa użytkownika jest już zajęta"
                binding.exception.visibility = View.VISIBLE
            } else {
                if ( pass1 == pass2 ) {
                    Log.d("Third", "I'm here")
                    UserManager.addUser(log, pass1)
                    val action = SignInDirections.actionSignInToLogIn(log, pass1)
                    Navigation.findNavController(requireView()).navigate(action)
                } else {
                    Log.d("Fith", "I'm here")

                    binding.exception.text = "Nie zgadzają się hasła"
                    binding.exception.visibility = View.VISIBLE
                }
            }
        }
        return binding.root
    }
}