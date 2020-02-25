package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.R
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters.PhotosListAdapter
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters.ScoresReviewsAdapter
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.models.ToursModel
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.models.ToursModelImpl
import kotlinx.android.synthetic.main.activity_tours_details.*

/**
 * Created by Phyoe Sandy Soe Tun
 * on 2/5/2020.
 */
class ToursDetailsActivity : BaseActivity(){
    private val mToursModel : ToursModel = ToursModelImpl

    private lateinit var photoAdapter: PhotosListAdapter
    private lateinit var scoresReviewsAdapter: ScoresReviewsAdapter
   
    companion object{
        const val IE_TOURS_NAME = "IE_TOURS_NAME"
        const val IE_COUNTRY_NAME = "IE_COUNTRY_NAME"

        fun newTourIntent(context : Context, toursName : String ) : Intent {
            val intent = Intent(context,ToursDetailsActivity::class.java)
            intent.putExtra(IE_TOURS_NAME,toursName)
            Log.d("Tours Name",toursName)
            return intent
        }

        fun newCountryIntent(context : Context, countryName : String ) : Intent {
            val intent = Intent(context,ToursDetailsActivity::class.java)
            intent.putExtra(IE_COUNTRY_NAME,countryName)
            Log.d("Country Name",countryName)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tours_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupRecyclerView()
        bindcountryData()
        bindtourData()

        btnBack.setOnClickListener {
             finish()
         }
    }

    private fun setupRecyclerView(){
        photoAdapter = PhotosListAdapter()
        val hLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvPhotos.layoutManager = hLayoutManager
        rvPhotos.adapter =  photoAdapter

        scoresReviewsAdapter = ScoresReviewsAdapter()
        rvScroeReview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvScroeReview.adapter = scoresReviewsAdapter
    }

    private fun bindcountryData() {
        val countryName = intent.getStringExtra(IE_COUNTRY_NAME)
        val country = mToursModel.getCountryByName(countryName)

        Glide.with(this)
            .load(country.photos[0])
            .into(ivPhotos)

        tvName.text = country.name
        tvDescription.text = country.description
        tvLocation.text = country.location

        photoAdapter.setNewData(country.photos)
        scoresReviewsAdapter.setNewData(country.scoresAndReviews)
    }

    private fun bindtourData(){
        val toursName = intent.getStringExtra(IE_TOURS_NAME)
        val tours = mToursModel.getToursByName(toursName)

        Glide.with(this)
            .load(tours.photos[0])
            .into(ivPhotos)

        tvName.text = tours.name
        tvDescription.text = tours.description
        tvLocation.text = tours.location

        photoAdapter.setNewData(tours.photos)
        scoresReviewsAdapter.setNewData(tours.scoresAndReviews)
    }
}