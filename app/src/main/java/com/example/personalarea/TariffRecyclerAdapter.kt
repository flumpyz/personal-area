package com.example.personalarea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.model.Tariff

class TariffRecyclerAdapter(private val tariffList: MutableList<Tariff>):
    RecyclerView.Adapter<TariffRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val speedTextView: TextView = itemView.findViewById(R.id.textViewSpeed)
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
        holder.nameTextView.text = tariffList[position].title
        holder.speedTextView.text = tariffList[position].speed.toString()
        holder.costTextView.text = tariffList[position].cost.toString()

        if (position == 0) {
            holder.line.isVisible = false
        }
    }

    override fun getItemCount(): Int {
        return tariffList.size
    }
}