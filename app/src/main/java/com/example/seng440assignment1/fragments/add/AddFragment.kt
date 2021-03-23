package com.example.seng440assignment1.fragments.add


import DateConverter.fromDate
import DateConverter.toDate
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.seng440assignment1.R
import com.example.seng440assignment1.data.RatingEntry
import com.example.seng440assignment1.data.RatingEntryViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {

    private lateinit var mRatingEntryViewModel: RatingEntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mRatingEntryViewModel = ViewModelProvider(this).get(RatingEntryViewModel::class.java)

        view.submit_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }


    private fun insertDataToDatabase() {
        val rating = seekBar3.progress
        //val sdf = SimpleDateFormat("dd/M/yyyy")
        //val currentDate = sdf.format(Date())
        val tags = tag_box.text.toString()

        if (!(inputCheck(tags)))
        {
            Toast.makeText(activity, "Please enter at least one tag!", Toast.LENGTH_LONG).show()
        } else {
            val date = fromDate(Date())

            val entry = RatingEntry(0, date, rating, tags)
            mRatingEntryViewModel.addEntry(entry)
            Toast.makeText(activity, "Successfully added an entry!", Toast.LENGTH_LONG).show()
            println(entry)
            println(toDate(entry.date))

            findNavController().navigate(R.id.action_addFragment_to_viewFragment)
        }

    }

    private fun inputCheck(tags: String): Boolean {
        return !(TextUtils.isEmpty(tags))
    }
}