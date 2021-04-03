package com.example.seng440assignment1.fragments.visualise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seng440assignment1.R
import com.example.seng440assignment1.data.RatingEntry
import kotlinx.android.synthetic.main.custom_row.view.*
import java.text.SimpleDateFormat

class ViewAdapter: RecyclerView.Adapter<ViewAdapter.MyViewHolder>() {

    private var entryList = emptyList<RatingEntry>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        println("this is happening")
        val currentItem = entryList[position]
        holder.itemView.row_id.text = currentItem.id.toString()
        val formatter = SimpleDateFormat("dd/MM/yy")

        holder.itemView.row_date.text = formatter.format(currentItem.date)
        holder.itemView.row_rating.text = currentItem.rating.toString()
        holder.itemView.row_tags.text = currentItem.tags
    }

    fun setData(ratingEntry: List<RatingEntry>){
        this.entryList = ratingEntry
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return entryList.size
    }
}