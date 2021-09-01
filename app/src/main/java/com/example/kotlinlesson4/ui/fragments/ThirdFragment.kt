package com.example.kotlinlesson4.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinlesson4.MainViewModel
import com.example.kotlinlesson4.R
import com.example.kotlinlesson4.databinding.FragmentThirdBinding
import com.example.kotlinlesson4.ui.fragments.adapter.CommandsAdapter

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private lateinit var binding:FragmentThirdBinding
    private lateinit var viewModel: MainViewModel
    private var myAdapter:CommandsAdapter? = null
    private var list:ArrayList<String> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModel.commands.observe(viewLifecycleOwner){ operator ->

            Log.d("tag","operators: $operator")
            Log.d("tag","list: $list")

            myAdapter?.addData(operator)

        }

        myAdapter = CommandsAdapter(list)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }

    }

}