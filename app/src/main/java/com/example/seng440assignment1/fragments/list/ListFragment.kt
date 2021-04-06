package com.example.seng440assignment1.fragments.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.seng440assignment1.R
import kotlinx.android.synthetic.main.fragment_list.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.logButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        view.viewButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_viewFragment)
        }

        view.graphButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_graphFragment)
        }

        view.emailButton.setOnClickListener {
            sendIntent()
        }

        return view
    }

    fun sendIntent(){
        var calendar = Calendar.getInstance()
        val intent = Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI).apply {
            val beginTime: Calendar = Calendar.getInstance().apply {
                set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1, 12, 0)
            }
            val endTime = Calendar.getInstance().apply {
                set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1, 13, 0)
            }
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.timeInMillis)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.timeInMillis)
            putExtra(CalendarContract.Events.TITLE, "Use Health Visualiser")
            putExtra(CalendarContract.Events.EVENT_LOCATION, "On your phone")
        }
        startActivity(intent)

    }


}