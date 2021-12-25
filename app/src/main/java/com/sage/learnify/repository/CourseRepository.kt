package com.sage.learnify.repository

import com.sage.learnify.api.RetrofitClient
import com.sage.learnify.model.ApiCourseResponse
import com.sage.learnify.model.ResultsItem
import com.sage.learnify.ui.home.HomeFragmentViewModel
import retrofit2.Response

class CourseRepository {
    private val retrofit = RetrofitClient.createRetrofitClient()
    private val token = "Basic c2RkdkRFeTlGRGlIdHluTFFwYWw0SUhiej" +
            "FWVXlxVmVtWHBpZTdMRDpNeWhoalBXd05BcTV6SWhDYW1lUWlSYj" +
            "NEeEd1a1pwWTcxTGd2ekRYOXJaZnZsdk9QTUdMRXh5UGUzVkF0VX" +
            "JRMDc4ZEtMQWZtRVpoTnZjQ3JZN0Y2TTNnYlNSRENVd2k3M0hXdU" +
            "5ZeVAxWUJJVEZSWjRWZHVSWDZoNnZFejJHNg=="

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

}