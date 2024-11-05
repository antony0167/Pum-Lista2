package com.example.lista2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.lista2.databinding.FragmentHelloBinding

class Hello : Fragment() {

    private lateinit var binding: FragmentHelloBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelloBinding.inflate(inflater)

        binding.btnLogin.setOnClickListener {
            val actionLogin = HelloDirections.actionHelloToLogIn()
            Navigation.findNavController(requireView()).navigate(actionLogin)
        }

        binding.btnRegister.setOnClickListener {
            val actionRegister = HelloDirections.actionHelloToSignIn()
            Navigation.findNavController(requireView()).navigate(actionRegister)
        }

        return binding.root
    }
}