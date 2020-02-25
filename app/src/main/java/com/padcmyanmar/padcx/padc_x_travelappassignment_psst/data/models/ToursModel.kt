package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.models

import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.ToursVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
interface ToursModel {
    fun getAllTours(onSuccess : (DataVO) -> Unit,
                    onFailure : (String) -> Unit)

    fun getToursByName(toursName: String) : ToursVO

    fun getCountryByName(countryName: String): ToursVO
}
