package com.example.lista2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.lista2.databinding.FragmentContentBinding

class Content : Fragment() {

    private lateinit var binding: FragmentContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(inflater)

        binding.welcomeText.text = "Witaj ${arguments?.getString("username")}"

        binding.btnLogout.setOnClickListener {
            val action = ContentDirections.actionContent2ToHello()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return binding.root
    }
}