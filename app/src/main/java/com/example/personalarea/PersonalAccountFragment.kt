package com.example.personalarea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class PersonalAccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.personal_account_fragment, container, false)
        val personalAccountNumber: TextView = rootView.findViewById(R.id.personalAccountNumber)
        val balance: TextView = rootView.findViewById(R.id.balance)
        val sumToPay: TextView = rootView.findViewById(R.id.sumToPay)

        personalAccountNumber.text = "11010010"
        balance.text = "100.42"
        sumToPay.text = "0.00"

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}