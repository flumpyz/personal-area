package com.example.personalarea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class UserRecyclerAdapter(private val iconResources: List<Int>, private val texts: List<String>) :
    RecyclerView.Adapter<UserRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userInfoIcon: ImageView = itemView.findViewById(R.id.userInfoIcon)
        val userInfoText: TextView = itemView.findViewById(R.id.userInfoText)
        val line: View = itemView.findViewById(R.id.line)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserRecyclerAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_info_item, parent, false)
        return UserRecyclerAdapter.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserRecyclerAdapter.MyViewHolder, position: Int) {
        holder.userInfoIcon.setImageResource(iconResources[position])
        holder.userInfoText.text = texts[position]

        if (position == 0) {
            holder.line.isVisible = false
        }
    }

    override fun getItemCount(): Int {
        return texts.size
    }

}