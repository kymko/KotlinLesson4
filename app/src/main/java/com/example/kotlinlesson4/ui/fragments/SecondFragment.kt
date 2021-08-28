package com.example.kotlinlesson4.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinlesson4.MainViewModel
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.counter.observe(viewLifecycleOwner,  {
            binding.tvResult.text = it.toString()
            Log.d("tag", "plus:$tv_result")
        })

        viewModel.counter.observe(viewLifecycleOwner,{
            binding.tvResult.text = it.toString()
        })
    }
}