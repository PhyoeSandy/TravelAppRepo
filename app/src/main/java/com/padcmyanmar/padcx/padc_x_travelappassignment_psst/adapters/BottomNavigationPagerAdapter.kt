package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.fragments.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/12/2020.
 */
class BottomNavigationPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { return HomeFragment.newInstance("A","B")}
            1 -> { return RatingFragment.newInstance("a","b")}
            2 -> { return FavoriteFragment.newInstance("a","b")}
            3 -> { return PriceFragment.newInstance("a","b")}
            4 -> { return SearchFragment.newInstance("a","b")}
          else-> {return HomeFragment.newInstance("A","B")}
        }
    }
}