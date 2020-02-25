package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network

import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.responses.GetAllToursResponse
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.uils.GET_TOURS
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
interface ToursApi {
    @GET(GET_TOURS)
    fun getAllTours(): Call<GetAllToursResponse>

}