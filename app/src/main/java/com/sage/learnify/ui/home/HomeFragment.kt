package com.sage.learnify.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.sage.learnify.R
import com.sage.learnify.adapter.HomeCourseAdapter
import com.sage.learnify.adapter.HomeRecommendedAdapter
import com.sage.learnify.databinding.FragmentHomeBinding
import com.sage.learnify.databinding.ItemCourseHomeBinding
import com.sage.learnify.model.ResultsItem
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val homeCourseAdapter = HomeCourseAdapter()
        val recommendedAdapter = HomeRecommendedAdapter()



        binding.courseHomeRecycler.adapter = homeCourseAdapter
        binding.recommendedCourseHomeRecycler.adapter = recommendedAdapter

        binding.showAllCourses.setOnClickListener {view ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_courseFragment)
        }

        lifecycleScope.launch {
            viewModel.getCourseListWithSize().observe(viewLifecycleOwner){responseList ->
                val arrayList = responseList.results as ArrayList<ResultsItem>
                homeCourseAdapter.resultItem = arrayList
                homeCourseAdapter.notifyDataSetChanged()

            }

            viewModel.getRecommendedCourseList().observe(viewLifecycleOwner){responseList ->
                val arrayList = responseList.results as ArrayList<ResultsItem>
                recommendedAdapter.resultList = arrayList
                recommendedAdapter.notifyDataSetChanged()
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }


}