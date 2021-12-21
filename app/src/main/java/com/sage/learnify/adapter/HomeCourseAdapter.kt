package com.sage.learnify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sage.learnify.R
import com.sage.learnify.databinding.ItemCourseHomeBinding
import com.sage.learnify.model.ApiCourseResponse
import com.sage.learnify.model.ResultsItem
import java.util.ArrayList

class HomeCourseAdapter(private val listener: ClickListener) :
    RecyclerView.Adapter<HomeCourseAdapter.ViewHolder>() {

    var resultItem = arrayListOf<ResultsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPosition = resultItem[position]
        holder.bind(itemPosition)
        holder.itemView.setOnClickListener {
            listener.onClick(itemPosition)
        }
    }

    override fun getItemCount(): Int = resultItem.size

    class ViewHolder(private val binding: ItemCourseHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(resultsItem: ResultsItem) {
            binding.itemCourseHomeTitle.text = resultsItem.title
            binding.itemCourseHomeImage.load(resultsItem.image480x270)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    ItemCourseHomeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    class ClickListener(private val clicks: (ResultsItem) -> Unit) {
        fun onClick(result: ResultsItem) = clicks(result)
    }

}