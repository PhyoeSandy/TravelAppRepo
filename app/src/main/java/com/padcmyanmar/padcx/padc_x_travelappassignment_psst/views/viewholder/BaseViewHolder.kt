package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mData : T? = null
    abstract fun bindData(data: T) //view holder binding data type
}