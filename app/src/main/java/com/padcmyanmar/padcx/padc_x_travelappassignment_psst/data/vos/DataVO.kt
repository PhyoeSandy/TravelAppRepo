package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
data class DataVO(
    @SerializedName("country") val country: ArrayList<ToursVO> = arrayListOf(),
    @SerializedName("popular_tours") val populorTours: ArrayList<ToursVO> = arrayListOf()
)