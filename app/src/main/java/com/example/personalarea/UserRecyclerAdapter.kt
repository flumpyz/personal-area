package com.example.personalarea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.model.UserInfo

class UserRecyclerAdapter(private val userIconList: List<Int>, private val userInfoList: MutableList<String>) :
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
        holder.userInfoIcon.setImageResource(userIconList[position])
        holder.userInfoText.text = userInfoList[position]

        if (position == 0) {
            holder.line.isVisible = false
        }
    }

    override fun getItemCount(): Int {
        return userInfoList.size
    }

}