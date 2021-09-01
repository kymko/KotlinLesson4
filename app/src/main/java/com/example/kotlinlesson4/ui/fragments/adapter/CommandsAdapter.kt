package com.example.kotlinlesson4.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlesson4.databinding.ListItemBinding

class CommandsAdapter(private var commands:ArrayList<String>) : RecyclerView.Adapter<CommandsAdapter.ViewHolder>() {

    private lateinit var binding: ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(commands[position])
    }
    fun addData(string: String){
        this.commands.clear()
        this.commands.add(string)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
     return commands.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ListItemBinding.bind(itemView)

        fun onBind(s: String) {

            binding.tvCommandsRecycler.text = s

        }

    }
}