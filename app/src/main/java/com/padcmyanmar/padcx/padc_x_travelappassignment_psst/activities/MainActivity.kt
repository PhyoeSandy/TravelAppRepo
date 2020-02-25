package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.R
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters.BottomNavigationPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupFragment()
        connectFragBottomNav()
    }

    private fun setupFragment(){
        val pagerAdapter = BottomNavigationPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        viewPager.currentItem = 0

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottomNavigation.selectedItemId = R.id.action_home
                    1 -> bottomNavigation.selectedItemId = R.id.action_rating
                    2 -> bottomNavigation.selectedItemId = R.id.action_favoirte
                    3 -> bottomNavigation.selectedItemId = R.id.action_price
                    4 -> bottomNavigation.selectedItemId = R.id.action_search
                }
            }
        })
    }

    private fun connectFragBottomNav(){
        bottomNavigation.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener{

                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.action_home -> {
                            viewPager.currentItem = 0
                            return true
                        }
                        R.id.action_rating -> {
                            viewPager.currentItem = 1
                            return true
                        }
                        R.id.action_favoirte -> {
                            viewPager.currentItem = 2
                            return true
                        }
                        R.id.action_price -> {
                            viewPager.currentItem = 3
                            return true
                        }
                        R.id.action_search -> {
                            viewPager.currentItem = 4
                            return true
                        }
                    }
                    return false
                }
            })
    }
}


