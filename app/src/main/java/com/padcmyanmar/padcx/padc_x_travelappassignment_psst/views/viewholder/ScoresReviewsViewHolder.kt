package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewholder

import android.view.View
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.ScoresReviewsVO
import kotlinx.android.synthetic.main.item_scores_reviews.view.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/9/2020.
 */
class ScoresReviewsViewHolder(itemView: View) : BaseViewHolder<ScoresReviewsVO>(itemView) {

    override fun bindData(data: ScoresReviewsVO) {
       itemView.tvName.text = data.name
       itemView.tvScore.text = data.score.toString()
       itemView.tvMaxScore.text = data.maxScore.toString()
       itemView.tvReviews.text = data.totalReviews.toString()
    }
}