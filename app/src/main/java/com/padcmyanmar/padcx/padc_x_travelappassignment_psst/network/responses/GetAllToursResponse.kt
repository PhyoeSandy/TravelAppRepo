package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.uils.SUCCESS_CODE_RESPONSE

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
data class GetAllToursResponse (
    @SerializedName("code") val code : Int = 0,
    @SerializedName("message") val message : String = "",
    @SerializedName("data") val data : DataVO ?= null
){
    fun isResponseOk(): Boolean = (data != null) && (code == SUCCESS_CODE_RESPONSE)
}