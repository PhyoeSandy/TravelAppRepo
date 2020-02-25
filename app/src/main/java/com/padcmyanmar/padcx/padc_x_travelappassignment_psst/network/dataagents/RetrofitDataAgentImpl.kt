package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.dataagents

import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.ToursApi
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.responses.GetAllToursResponse
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.uils.BASE_URL
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.uils.EM_NO_INTERNET_CONNECTION
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
object RetrofitDataAgentImpl : ToursDataAgent {
    private var mToursApi : ToursApi? = null

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        mToursApi = retrofit.create(ToursApi::class.java)
    }

    override fun getAllTours(onSuccess: (DataVO) -> Unit, onFailure: (String) -> Unit) {
        val getAllToursCall = mToursApi?.getAllTours()
        getAllToursCall?.enqueue(object: Callback<GetAllToursResponse>{
            override fun onFailure(call: Call<GetAllToursResponse>, t: Throwable) {
                onFailure(t.message ?: EM_NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetAllToursResponse>,
                response: Response<GetAllToursResponse>
            ) {
                val getAllToursResponse = response.body()
                if(getAllToursResponse != null){
                    if(getAllToursResponse.isResponseOk()){
                        getAllToursResponse.data?.let {
                            onSuccess.invoke(it)
                        }
                    }else{
                        onFailure(getAllToursResponse.message)
                    }
                }else{
                    onFailure(EM_NO_INTERNET_CONNECTION)
                }
            }
        })
    }
}