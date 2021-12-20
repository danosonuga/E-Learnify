package com.sage.learnify.repository

import com.sage.learnify.api.RetrofitClient
import com.sage.learnify.model.ApiCourseResponse
import com.sage.learnify.model.ResultsItem
import com.sage.learnify.ui.home.HomeFragmentViewModel
import retrofit2.Response

class CourseRepository {
    private val retrofit = RetrofitClient.createRetrofitClient()
    private val token = "Basic c2RkdkRFeTlGRGlIdHluTFFwYWw0SUhiejFWVXlx" +
            "VmVtWHBpZTdMRDpNeWhoalBXd05BcTV6SWhDYW1lUWlSY" +
            "jNEeEd1a1pwWTcxTGd2ekRYOXJaZnZsdk9QTUdMRXh5UGUz" +
            "VkF0VXJRMDc4ZEtMQWZtRVpoTnZjQ3JZN0Y2TTNnYlNSRENV" +
            "d2k3M0hXdU5ZeVAxWUJJVEZSWjRWZHVSWDZoNnZFejJHNg=="

    private val PAGE_SIZE = 5
    private val duration = "medium"

    suspend fun getCourseListWithSize(): Response<ApiCourseResponse> {
        return retrofit.getCourseListWithSize(token, PAGE_SIZE)
    }

    suspend fun getRecommendedCourseList(): Response<ApiCourseResponse>{
        return retrofit.getRecommendedCourseList(token, duration)
    }

    suspend fun getAllCourses(): Response<ApiCourseResponse>{
        return retrofit.getAllCourses(token)
    }

//    suspend fun getCourseById(): Response<ApiCourseResponse>{
//        return retrofit.getCourseById(token)
//    }
}