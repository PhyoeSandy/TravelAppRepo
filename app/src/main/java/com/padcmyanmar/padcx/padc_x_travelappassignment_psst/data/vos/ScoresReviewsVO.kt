package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
data class ScoresReviewsVO(
    @SerializedName("name") val name: String = "",
    @SerializedName("score") val score: Double = 0.0,
    @SerializedName("max_score") val maxScore: Int = 0,
    @SerializedName("total_reviews") val totalReviews: Int = 0
)