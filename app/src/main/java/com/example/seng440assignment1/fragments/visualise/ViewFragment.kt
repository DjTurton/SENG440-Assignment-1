package com.example.seng440assignment1.fragments.visualise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seng440assignment1.R
import com.example.seng440assignment1.data.RatingEntryViewModel
import kotlinx.android.synthetic.main.fragment_view.view.*

class ViewFragment : Fragment() {

    private lateinit var mRatingEntryViewModel: RatingEntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view, container, false)

        val adapter = ViewAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mRatingEntryViewModel = ViewModelProvider(this).get(RatingEntryViewModel::class.java)
        mRatingEntryViewModel.readAllData.observe(viewLifecycleOwner, Observer { ratingEntry ->
            adapter.setData(ratingEntry)
         })

        return view
    }

}