package com.sage.learnify.ui.course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sage.learnify.R
import com.sage.learnify.adapter.CourseListAdapter
import com.sage.learnify.databinding.FragmentCourseBinding
import com.sage.learnify.model.ResultsItem
import kotlinx.coroutines.launch


class CourseFragment : Fragment() {

    private lateinit var binding: FragmentCourseBinding
    private val viewModel: CourseListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(layoutInflater, container, false)

        val courseListAdapter = CourseListAdapter()

        binding.courseListRecycler.adapter = courseListAdapter

        lifecycleScope.launch {
            viewModel.getAllCourses().observe(viewLifecycleOwner){responseList ->
                val arrayList = responseList.results as ArrayList<ResultsItem>
                courseListAdapter.resultList = arrayList
                courseListAdapter.notifyDataSetChanged()
            }
        }
        return binding.root
    }

}