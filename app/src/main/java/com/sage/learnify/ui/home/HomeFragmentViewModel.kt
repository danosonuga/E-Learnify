package com.sage.learnify.ui.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sage.learnify.model.ApiCourseResponse
import com.sage.learnify.model.ResultsItem
import com.sage.learnify.repository.CourseRepository

class HomeFragmentViewModel : ViewModel() {
    private val repository = CourseRepository()

    suspend fun getCourseListWithSize(): LiveData<ApiCourseResponse>{
        val mutableLiveData = MutableLiveData<ApiCourseResponse>()
        val allCourses = repository.getCourseListWithSize()

        if (allCourses.isSuccessful){
            mutableLiveData.value = allCourses.body()
        }else{
            Log.e("Error Message", allCourses.message())
        }
        return mutableLiveData
    }

    suspend fun getRecommendedCourseList(): LiveData<ApiCourseResponse>{
        val mutableLiveData = MutableLiveData<ApiCourseResponse>()
        val freeCourses = repository.getRecommendedCourseList()

        if (freeCourses.isSuccessful){
            mutableLiveData.value = freeCourses.body()
        }else{
            Log.e("Error Message", freeCourses.message())
        }
        return mutableLiveData
    }

}