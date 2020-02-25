package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.R
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewholder.PhotoViewHolder


/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/7/2020.
 */

class PhotosListAdapter: BaseRecyclerAdapter<PhotoViewHolder, String>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photos,parent,false)
        return PhotoViewHolder(view)
    }
}
