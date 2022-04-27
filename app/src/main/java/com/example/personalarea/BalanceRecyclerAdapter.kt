package com.example.personalarea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.model.Balance

class BalanceRecyclerAdapter(private val balanceInfo: Balance?) :
    RecyclerView.Adapter<BalanceRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val accountNumber: TextView = itemView.findViewById(R.id.personalAccountNumber)
        val balance: TextView = itemView.findViewById(R.id.balance)
        val sumToPay: TextView = itemView.findViewById(R.id.sumToPay)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.personal_account_fragment, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.accountNumber.text = balanceInfo?.accNum.toString()
        holder.balance.text = balanceInfo?.balance.toString()
        holder.sumToPay.text = balanceInfo?.nextPay.toString()
    }

    override fun getItemCount(): Int {
        return 1;
    }

}