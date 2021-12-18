package com.sage.learnify.ui.home

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sage.learnify.BR
import com.sage.learnify.R
import com.sage.learnify.adapter.HomeCourseAdapter
import com.sage.learnify.databinding.FragmentHomeBinding
import com.sage.learnify.databinding.ItemCourseHomeBinding
import com.sage.learnify.model.Course
import com.sage.learnify.model.Result

class HomeFragment : Fragment() {


    private val viewModel by lazy {
        ViewModelProvider(this)[HomeFragmentViewModel::class.java]
    }

    private lateinit var binding: ItemCourseHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val view = LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
        binding = ItemCourseHomeBinding.inflate(inflater)

        binding.lifecycleOwner = this
//        val myViewModel = makeApiCall()
//
//        setUpBinding(myViewModel)

        setHasOptionsMenu(true)
        return binding.root
    }
//
//    private fun setUpBinding(viewModel: HomeFragmentViewModel) {
//        val binding: FragmentHomeBinding = DataBindingUtil.setContentView(context as Activity, R.layout.fragment_home)
//        binding.setVariable(BR.viewModel, viewModel)
//        binding.executePendingBindings()
//        binding.courseHomeRecycler.apply {
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        }
//    }
//
//    private fun makeApiCall(): HomeFragmentViewModel{
//        viewModel.getCourseResultDataObserver().observe(viewLifecycleOwner, Observer<Course> {
//            if (it != null){
//                viewModel.setAdapterData(it.results as ArrayList<Result>)
//            }else{
//                Toast.makeText(context, "Error while fetching", Toast.LENGTH_LONG).show()
//            }
//        })
//        viewModel.getCourseResult()
//
//        return viewModel
//    }

}