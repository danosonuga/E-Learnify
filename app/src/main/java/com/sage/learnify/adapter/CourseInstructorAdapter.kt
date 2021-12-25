package com.sage.learnify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sage.learnify.R
import com.sage.learnify.databinding.ItemCourseInstructorBinding
import com.sage.learnify.model.VisibleInstructorsItem

class CourseInstructorAdapter: RecyclerView.Adapter<CourseInstructorAdapter.ViewHolder>() {

    var instructorList = arrayListOf<VisibleInstructorsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPicked = instructorList[position]

        holder.bind(itemPicked)
    }

    override fun getItemCount(): Int {
        return instructorList.size
    }

    class ViewHolder(private val binding: ItemCourseInstructorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(instructorsItem: VisibleInstructorsItem) {
            binding.instructorProfile.load(instructorsItem.image100x100){
                placeholder(R.drawable.placeholder)
            }
            binding.instructorName.text = instructorsItem.displayName
            binding.instructorTitle.text = instructorsItem.jobTitle
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(
                    ItemCourseInstructorBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}