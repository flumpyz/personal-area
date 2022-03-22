package com.example.personalarea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class TariffRecyclerAdapter(private val names: List<String>, private val speeds: List<String>, private val costs: List<String>):
    RecyclerView.Adapter<TariffRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)
        val costTextView: TextView = itemView.findViewById(R.id.tariffCost)
        val line: View = itemView.findViewById(R.id.line)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.tariff_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.largeTextView.text = names[position]
        holder.smallTextView.text = speeds[position]
        holder.costTextView.text = costs[position]

        if (position == 0) {
            holder.line.isVisible = false
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }
}