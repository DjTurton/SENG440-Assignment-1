package com.example.seng440assignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.seng440assignment1.data.RatingEntry
import com.example.seng440assignment1.data.RatingEntryViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.fragment_graph.*

class GraphFragment : Fragment() {

    private var entryList = emptyList<RatingEntry>()
    private lateinit var mRatingEntryViewModel: RatingEntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mRatingEntryViewModel = ViewModelProvider(this).get(RatingEntryViewModel::class.java)
        mRatingEntryViewModel.readAllData.observe(viewLifecycleOwner, Observer { ratingEntry ->
            fillChart(ratingEntry)
            var entries:MutableList<Entry> = mutableListOf<Entry>()
            var dates:MutableList<String> = mutableListOf<String>()
            for (item in entryList) {
                entries.add(Entry(item.id.toFloat(), item.rating.toFloat()))
                dates.add(item.date.toString())
            }
            println(entries)
            println(dates)

            val dataSet = LineDataSet(entries, "graph")
            val lineData = LineData(dataSet)
            chart.data = lineData
            chart.invalidate()        })


        return inflater.inflate(R.layout.fragment_graph, container, false)
    }

    fun fillChart(ratingEntry: List<RatingEntry>) {
        this.entryList = ratingEntry
    }

}