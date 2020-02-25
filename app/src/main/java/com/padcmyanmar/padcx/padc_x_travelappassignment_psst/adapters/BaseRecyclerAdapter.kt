package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewholder.BaseViewHolder

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {
    var mData: MutableList<W> = arrayListOf()

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    fun setNewData(data: MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

    fun appendNewData(data: MutableList<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}