package com.sage.learnify.ui.course

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sage.learnify.model.ApiCourseResponse
import com.sage.learnify.repository.CourseRepository

class CourseListViewModel: ViewModel() {

    private val repository = CourseRepository()

    suspend fun getAllCourses(): LiveData<ApiCourseResponse>{
        val mutableLiveData = MutableLiveData<ApiCourseResponse>()
        val allPost = repository.getAllCourses()

        if (allPost.isSuccessful){
            mutableLiveData.value = allPost.body()
        }else{
            Log.d("Error Message", allPost.message())
        }
        return mutableLiveData
    }
}