package com.sage.learnify.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sage.learnify.databinding.ItemCourseHomeBinding
import com.sage.learnify.model.Course
import com.sage.learnify.model.Result
import com.sage.learnify.ui.home.HomeFragment
import java.util.ArrayList

class HomeCourseAdapter : RecyclerView.Adapter<HomeCourseAdapter.ViewHolder>() {

    var result = ArrayList<Result>()
    private lateinit var binding: ItemCourseHomeBinding

//    fun setDataList(data: ArrayList<Result>){
//        result = data
//    }

    inner class ViewHolder(val binding: ItemCourseHomeBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                //TODO: Do the onclicklistener
            }
        }

//        fun bind(data: Result){
//            binding.courses = data
//            binding.executePendingBindings()
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCourseHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(result[position])
    }

    override fun getItemCount(): Int = result.size

//    companion object{
//        @BindingAdapter("loadImage")
//        fun loadImage(item_course_home_image: ImageView, url: String){
//            item_course_home_image.load(url)
//        }
//    }
}