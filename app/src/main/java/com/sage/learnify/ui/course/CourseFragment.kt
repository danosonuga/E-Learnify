package com.sage.learnify.ui.course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sage.learnify.R
import com.sage.learnify.adapter.CourseListAdapter
import com.sage.learnify.databinding.FragmentCourseBinding
import com.sage.learnify.model.ResultsItem
import com.sage.learnify.utils.isNetworkAvailable
import kotlinx.coroutines.launch


class CourseFragment : Fragment() {

    private lateinit var binding: FragmentCourseBinding
    private val viewModel: CourseListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(layoutInflater, container, false)

        val courseListAdapter = CourseListAdapter(CourseListAdapter.ClickListener{
            val action = CourseFragmentDirections.actionCourseFragmentToCourseDetailFragment(it)
            findNavController().navigate(action)
        })

        binding.courseListRecycler.adapter = courseListAdapter

        if (isNetworkAvailable(requireContext())){
            binding.courseListRecycler.isVisible = true
            lifecycleScope.launch {
                viewModel.getAllCourses().observe(viewLifecycleOwner){responseList ->
                    val arrayList = responseList.results as ArrayList<ResultsItem>
                    courseListAdapter.resultList = arrayList
                    courseListAdapter.notifyDataSetChanged()
                }
            }
        }else {
            binding.courseListRecycler.isVisible = false
            Toast.makeText(context, "Check your network connection", Toast.LENGTH_LONG).show()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){errorMessage->
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

}