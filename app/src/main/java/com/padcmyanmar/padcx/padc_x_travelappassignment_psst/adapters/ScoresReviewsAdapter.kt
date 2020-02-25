package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.R
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.ScoresReviewsVO
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewholder.ScoresReviewsViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/7/2020.
 */
class ScoresReviewsAdapter: BaseRecyclerAdapter<ScoresReviewsViewHolder,ScoresReviewsVO>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoresReviewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scores_reviews,parent,false)
        return ScoresReviewsViewHolder(view)
    }
}