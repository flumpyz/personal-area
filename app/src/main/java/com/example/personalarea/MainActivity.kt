package com.example.personalarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tariffRecyclerView: RecyclerView = findViewById(R.id.tariffList)
        tariffRecyclerView.layoutManager = LinearLayoutManager(this)
        tariffRecyclerView.adapter = TariffRecyclerAdapter(getTariffList(), getSpeedsList(), getCostsList())

        val userRecyclerView: RecyclerView = findViewById(R.id.userInfoList)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = UserRecyclerAdapter(getUserInfoIcons(), getUserInfo())
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

    private fun getUserInfo(): List<String> {
        return this.resources.getStringArray(R.array.user_info).toList()
    }

    private fun getUserInfoIcons(): List<Int> {
        return listOf(R.drawable.user, R.drawable.home, R.drawable.dashboard)
    }
}