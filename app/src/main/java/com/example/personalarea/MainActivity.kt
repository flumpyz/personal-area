package com.example.personalarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.tariffList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TariffRecyclerAdapter(getTariffList(), getSpeedsList(), getCostsList())
    }

    private fun getTariffList(): List<String> {
        return this.resources.getStringArray(R.array.tariff_names).toList()
    }

    private fun getSpeedsList(): List<String> {
        return this.resources.getStringArray(R.array.tariff_speeds).toList()
    }

    private fun getCostsList(): List<String> {
        return this.resources.getStringArray(R.array.tariff_costs).toList()
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..5).forEach { i -> data.add("$i element") }
        return data
    }
}