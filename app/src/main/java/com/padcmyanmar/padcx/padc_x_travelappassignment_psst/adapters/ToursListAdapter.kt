package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.R
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.vos.ToursVO
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.delegates.ToursItemDelegate
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewholder.BaseTravelViewHolder
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewholder.TourViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
class ToursListAdapter(delegate: ToursItemDelegate) : BaseRecyclerAdapter<BaseTravelViewHolder,ToursVO>(){
    val mDelegate : ToursItemDelegate =delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTravelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tours,parent,false)
        return TourViewHolder(view,mDelegate)
    }

}