package com.sage.learnify.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sage.learnify.R
import com.sage.learnify.adapter.HomeCourseAdapter
import com.sage.learnify.adapter.HomeRecommendedAdapter
import com.sage.learnify.databinding.FragmentHomeBinding
import com.sage.learnify.databinding.ItemCourseHomeBinding
import com.sage.learnify.model.ResultsItem
import com.sage.learnify.utils.isNetworkAvailable
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val homeCourseAdapter = HomeCourseAdapter(HomeCourseAdapter.ClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCourseDetailFragment(it)
            findNavController().navigate(action)
        })
        val recommendedAdapter = HomeRecommendedAdapter(HomeRecommendedAdapter.ClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToCourseDetailFragment(it)
            findNavController().navigate(action)
        })



        binding.courseHomeRecycler.adapter = homeCourseAdapter
        binding.recommendedCourseHomeRecycler.adapter = recommendedAdapter

        binding.showAllCourses.setOnClickListener {view ->
            val action = HomeFragmentDirections.actionHomeFragmentToCourseFragment()
            findNavController().navigate(action)
        }

        if (isNetworkAvailable(requireContext())){
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
        }else{
            binding.recommendedCourseHomeRecycler.isVisible = false
            binding.courseHomeRecycler.isVisible = false
            Toast.makeText(context, "Check your network connection.", Toast.LENGTH_LONG).show()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){errorMessage ->
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
        }

        setHasOptionsMenu(true)
        return binding.root
    }


}