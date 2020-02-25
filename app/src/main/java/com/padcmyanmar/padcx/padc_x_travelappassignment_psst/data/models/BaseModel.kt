package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.models

import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.dataagents.RetrofitDataAgentImpl
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.dataagents.ToursDataAgent

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
abstract class BaseModel {
    val mDataAgent :ToursDataAgent = RetrofitDataAgentImpl
}