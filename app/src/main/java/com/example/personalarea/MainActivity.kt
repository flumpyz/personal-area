package com.example.personalarea

import RetrofitServices
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalarea.common.Common
import com.example.personalarea.databinding.ActivityMainBinding
import com.example.personalarea.model.Balance
import com.example.personalarea.model.DataModel
import com.example.personalarea.model.Tariff
import com.example.personalarea.model.UserInfo
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var retrofitService: RetrofitServices
    lateinit var tariffRecyclerAdapter: TariffRecyclerAdapter
    lateinit var userRecyclerAdapter: UserRecyclerAdapter
    private val dataModel: DataModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitService = Common.retrofitService

        val tariffs : MutableList<Tariff> = mutableListOf()
        tariffRecyclerAdapter = TariffRecyclerAdapter(tariffs)

        val tariffRecyclerView: RecyclerView = findViewById(R.id.tariffList)
        tariffRecyclerView.layoutManager = LinearLayoutManager(this)
        tariffRecyclerView.adapter = tariffRecyclerAdapter

        val userInfo : MutableList<String> = mutableListOf()
        userRecyclerAdapter = UserRecyclerAdapter(getUserInfoIcons(), userInfo)

        val userRecyclerView: RecyclerView = findViewById(R.id.userInfoList)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = userRecyclerAdapter

        getData(tariffs, userInfo)
    }

    private fun getData(tariffs : MutableList<Tariff>, userInfo : MutableList<String>) {
        MainScope().launch {
            retrofitService.getTariffList().enqueue(object : Callback<MutableList<Tariff>> {
                override fun onFailure(call: Call<MutableList<Tariff>>, t: Throwable) {
                    val e = t
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<MutableList<Tariff>>, response: Response<MutableList<Tariff>>) {
                    val tariffList = (response.body() as List<Tariff>).toMutableList()
                    tariffs.clear()
                    tariffs.addAll(tariffList)

                    tariffRecyclerAdapter.notifyDataSetChanged()
                }

            })

            retrofitService.getUserInfoList().enqueue(object : Callback<MutableList<UserInfo>> {
                override fun onFailure(call: Call<MutableList<UserInfo>>, t: Throwable) {
                    val e = t
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<MutableList<UserInfo>>, response: Response<MutableList<UserInfo>>) {
                    val userInfoList = (response.body() as List<UserInfo>)

                    val user = userInfoList.first()

                    userInfo.add("${user.firstName} ${user.lastName}")
                    userInfo.add("${user.address}")
                    userInfo.add("Доступные услуги")

                    userRecyclerAdapter.notifyDataSetChanged()
                }

            })

            retrofitService.getBalanceList().enqueue(object : Callback<MutableList<Balance>> {
                override fun onFailure(call: Call<MutableList<Balance>>, t: Throwable) {
                    val e = t
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<MutableList<Balance>>, response: Response<MutableList<Balance>>) {
                    val balanceInfoList = response.body() as List<Balance>
                    val balance = balanceInfoList.first()

                    dataModel.message.value = balance
                }

            })
        }
    }

    private fun getUserInfoIcons(): List<Int> {
        return listOf(R.drawable.user, R.drawable.home, R.drawable.dashboard)
    }
}