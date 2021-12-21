package com.sage.learnify.api

import com.sage.learnify.model.ApiCourseResponse
import com.sage.learnify.model.ResultsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface UdemyCourseService {

    @GET("courses/")
    suspend fun getCourseListWithSize(
        @Header("Authorization") authorization: String,
        @Query("page_size") pageSize: Int
    ): Response<ApiCourseResponse>

    @GET("courses/")
    suspend fun getRecommendedCourseList(
        @Header("Authorization") authorization: String,
        @Query("duration") duration: String
    ): Response<ApiCourseResponse>

    @GET("courses/")
    suspend fun getAllCourses(
        @Header("Authorization") authorization: String
    ): Response<ApiCourseResponse>


}