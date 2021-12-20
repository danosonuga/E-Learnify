package com.sage.learnify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sage.learnify.R
import com.sage.learnify.databinding.ItemCourseHomeBinding
import com.sage.learnify.model.ResultsItem

class HomeRecommendedAdapter : RecyclerView.Adapter<HomeRecommendedAdapter.ViewHolder>() {

    var resultList = arrayListOf<ResultsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPicked = resultList[position]
        holder.bind(itemPicked)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    class ViewHolder(private val binding: ItemCourseHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { view ->
                Navigation.findNavController(view)
                    .navigate(R.id.action_homeFragment_to_courseDetailFragment)
            }
        }

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
}