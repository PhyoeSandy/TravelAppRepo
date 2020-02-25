package com.padcmyanmar.padcx.padc_x_travelappassignment_psst.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.R
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.activities.ToursDetailsActivity
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters.CountryListAdapter
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.adapters.ToursListAdapter
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.models.ToursModel
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.data.models.ToursModelImpl
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.delegates.ToursItemDelegate
import com.padcmyanmar.padcx.padc_x_travelappassignment_psst.views.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.fragment_home.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), ToursItemDelegate{
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var tourAdapter: ToursListAdapter
    private lateinit var countryAdapter: CountryListAdapter
    private val mToursModel : ToursModel = ToursModelImpl

    private lateinit var viewPodEmpty : EmptyViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewPod()
        setupSwipeRefresh()
        hideEmptyView()
        setupRecyclerView()
        requestData()
    }


    private fun setupSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener {
            requestData()
        }
    }

    private fun requestData(){
      swipeRefreshLayout.isRefreshing = true

      mToursModel.getAllTours(
          onSuccess = {
              swipeRefreshLayout.isRefreshing = false
              if(it != null){
                 countryAdapter.setNewData(it.country)
                 tourAdapter.setNewData(it.populorTours)
              }else{
                  showEmptyView()
              }
          },
          onFailure = {
              swipeRefreshLayout.isRefreshing = false
              showEmptyView()
          }
      )
    }

    private fun setupRecyclerView(){
        countryAdapter = CountryListAdapter(this)
        val hLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = hLayoutManager
        rvCountry.adapter =  countryAdapter

        tourAdapter = ToursListAdapter(this)
        rvTour.layoutManager = LinearLayoutManager(activity)
        rvTour.adapter = tourAdapter
    }

    private fun showEmptyView(){
        vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView(){
        vpEmpty.visibility = View.GONE
    }

    private fun setupViewPod(){
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(
            "There are no tours available",
            "https://icons8.com/icon/46107/empty-box")
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onTapToursItem(toursName: String) {
        startActivity(ToursDetailsActivity.newTourIntent(requireContext(),toursName))
    }

    override fun onTapCountryItem(countryName: String) {
        startActivity(ToursDetailsActivity.newCountryIntent(requireContext(),countryName))
    }
}
