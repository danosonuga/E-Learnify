package com.sage.learnify.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sage.learnify.model.ApiCourseResponse
import com.sage.learnify.repository.CourseRepository

class HomeFragmentViewModel : ViewModel() {
    private val repository = CourseRepository()
    private val _errorMessage = MutableLiveData<String>()

    val errorMessage: LiveData<String>
    get() = _errorMessage

    suspend fun getCourseListWithSize(): LiveData<ApiCourseResponse>{
        val mutableLiveData = MutableLiveData<ApiCourseResponse>()
        val allCourses = repository.getCourseListWithSize()

        if (allCourses.isSuccessful){
            mutableLiveData.value = allCourses.body()
        }else{
            _errorMessage.value = "Error in network conection, please try again later!"
        }
        return mutableLiveData
    }

    suspend fun getRecommendedCourseList(): LiveData<ApiCourseResponse>{
        val mutableLiveData = MutableLiveData<ApiCourseResponse>()
        val freeCourses = repository.getRecommendedCourseList()


        if (freeCourses.isSuccessful){
            mutableLiveData.value = freeCourses.body()
        }else{
            _errorMessage.value = "Error in network connection, please try again later!"
        }
        return mutableLiveData
    }

}