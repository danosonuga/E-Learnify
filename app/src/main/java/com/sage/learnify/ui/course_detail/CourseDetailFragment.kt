package com.sage.learnify.ui.course_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.sage.learnify.R
import com.sage.learnify.adapter.CourseInstructorAdapter
import com.sage.learnify.databinding.FragmentCourseDetailBinding
import com.sage.learnify.model.VisibleInstructorsItem


class CourseDetailFragment : Fragment() {

    private val courseDetailFragmentArgs: CourseDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentCourseDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCourseDetailBinding.inflate(inflater, container, false)

        val instructorAdapter = CourseInstructorAdapter()

        binding.courseDetailImage.load(courseDetailFragmentArgs.response.image480x270)
        binding.courseDetailTitle.text = courseDetailFragmentArgs.response.title
        binding.courseHeadline.text = courseDetailFragmentArgs.response.headline
        binding.coursePaidValue.text = courseDetailFragmentArgs.response.price

        binding.courseInstructorRecycler.adapter = instructorAdapter

        val arrayList = courseDetailFragmentArgs.response.visibleInstructors as ArrayList<VisibleInstructorsItem>
        instructorAdapter.instructorList = arrayList
        instructorAdapter.notifyDataSetChanged()

        return binding.root
    }

}