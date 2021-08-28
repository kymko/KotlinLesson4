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
import com.example.kotlinlesson4.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_second.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this@FirstFragment).get(MainViewModel::class.java)

        binding.btnPlus.setOnClickListener{
            viewModel.onIncrementClick()
            Log.d("tag","clicked")
        }

        binding.btnMinus.setOnClickListener{
            viewModel.onItemDecrementClick()
        }

        viewModel.counter.observe(viewLifecycleOwner,  {
            binding.tvFirst.text = it.toString()
            Log.d("tag", "plus:$tv_result")
        })
    }

}