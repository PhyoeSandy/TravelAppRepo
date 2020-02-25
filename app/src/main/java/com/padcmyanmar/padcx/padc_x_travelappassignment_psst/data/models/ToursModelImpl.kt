package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.models

import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.DataVO
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.ToursVO

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
object ToursModelImpl : BaseModel(),ToursModel {
    val mToursRepository : HashMap<String,ToursVO> = hashMapOf()
    val mCountryRepository : HashMap<String,ToursVO> = hashMapOf()
    
    override fun getAllTours(onSuccess : (DataVO) -> Unit,
                             onFailure : (String) -> Unit) {
      mDataAgent.getAllTours(
          onSuccess = {
              it.country.forEach {country ->
                  mCountryRepository[country.name] = country
              }

              it.populorTours.forEach {tour ->
                  mToursRepository[tour.name] = tour
              }
              onSuccess.invoke(it)
          },
          onFailure = {
                onFailure.invoke(it)
          }
      )
    }

    override fun getCountryByName(countryName: String) : ToursVO {
        mCountryRepository[countryName]?.let {
            return it
        }
        return ToursVO()
    }

    override fun getToursByName(toursName: String) : ToursVO {
        mToursRepository[toursName]?.let {
            return it
        }
        return ToursVO()
    }
}