package com.sage.learnify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sage.learnify.R
import com.sage.learnify.databinding.ItemCourseHomeBinding
import com.sage.learnify.model.ResultsItem

class HomeRecommendedAdapter(private val listener: ClickListener) : RecyclerView.Adapter<HomeRecommendedAdapter.ViewHolder>() {

    var resultList = arrayListOf<ResultsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPicked = resultList[position]
        holder.bind(itemPicked)
        holder.itemView.setOnClickListener {
            listener.onClick(itemPicked)
        }
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

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

    class ClickListener(private val clicks: (ResultsItem)-> Unit){
        fun onClick(result: ResultsItem) = clicks(result)
    }
}