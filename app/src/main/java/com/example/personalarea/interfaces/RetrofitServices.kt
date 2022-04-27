import com.example.personalarea.model.Balance
import com.example.personalarea.model.Tariff
import com.example.personalarea.model.UserInfo
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("tariffs")
    fun getTariffList(): Call<MutableList<Tariff>>

    @GET("userInfo")
    fun getUserInfoList(): Call<MutableList<UserInfo>>

    @GET("balance")
    fun getBalanceList(): Call<MutableList<Balance>>
}