package com.example.personalarea

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.personalarea.databinding.PersonalAccountFragmentBinding
import com.example.personalarea.model.DataModel


class PersonalAccountFragment : Fragment() {
    lateinit var binding: PersonalAccountFragmentBinding
    private val dataModel: DataModel by activityViewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = PersonalAccountFragmentBinding.inflate(layoutInflater)
        dataModel.message.observe(activity as LifecycleOwner) {
            binding.sumToPay.text = (it.nextPay ?: 0).toString()
            binding.personalAccountNumber.text = (it.accNum ?: 0).toString()
            binding.balance.text = (it.balance ?: 0).toString()
        }

        return binding.root
    }

}