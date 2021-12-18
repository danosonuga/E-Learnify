package com.sage.learnify.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sage.learnify.model.Course
import com.sage.learnify.model.Result
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Header


private const val BASE_URL = "https://www.udemy.com/api-2.0/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

interface ApiService {
    @GET("courses/")
    suspend fun getCourseList(@Header("Authorization") Authorization: String):
            Deferred<Course>
}

object LearnifyApi{
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
