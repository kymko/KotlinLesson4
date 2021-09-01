package com.example.kotlinlesson4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlesson4.MainViewModel
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.databinding.FragmentThirdBinding
import java.lang.StringBuilder

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private lateinit var binding:FragmentThirdBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val builder = StringBuilder()
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.commands.observe(viewLifecycleOwner){
            binding.tvCommands.text = builder.append(it)
        }
    }
}