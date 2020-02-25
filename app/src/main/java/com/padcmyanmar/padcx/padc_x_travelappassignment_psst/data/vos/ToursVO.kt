package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
data class ToursVO (
    @SerializedName("name") val name: String = "",
    @SerializedName("description") val description : String = "",
    @SerializedName("location") val location : String = "",
    @SerializedName("average_rating") val averageRating : Double = 0.0,
    @SerializedName("scores_and_reviews") val scoresAndReviews : ArrayList<ScoresReviewsVO> = arrayListOf(),
    @SerializedName("photos") val photos: ArrayList<String> = arrayListOf()
)