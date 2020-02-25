package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.network.dataagents

import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.DataVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
interface ToursDataAgent {

    fun getAllTours(onSuccess: (DataVO) -> Unit,
                    onFailure: (String) -> Unit)
}