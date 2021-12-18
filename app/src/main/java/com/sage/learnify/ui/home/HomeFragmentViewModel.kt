package com.sage.learnify.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sage.learnify.adapter.HomeCourseAdapter
import com.sage.learnify.api.LearnifyApi
import com.sage.learnify.model.Course
import com.sage.learnify.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeFragmentViewModel : ViewModel() {
    val token = "c2RkdkRFeTlGRGlIdHluTFFwYWw0SUhiejFWVXlx" +
            "VmVtWHBpZTdMRDpNeWhoalBXd05BcTV6SWhDYW1lUWlSY" +
            "jNEeEd1a1pwWTcxTGd2ekRYOXJaZnZsdk9QTUdMRXh5UGUz" +
            "VkF0VXJRMDc4ZEtMQWZtRVpoTnZjQ3JZN0Y2TTNnYlNSRENV" +
            "d2k3M0hXdU5ZeVAxWUJJVEZSWjRWZHVSWDZoNnZFejJHNg=="

    private val _status = MutableLiveData<Result>()


    private val _results = MutableLiveData<Course>()

    val result: LiveData<Course> = _results
    val status: LiveData<Result> = _status

//    lateinit var homeCourseAdapter: HomeCourseAdapter


    init {
//        homeCourseAdapter = HomeCourseAdapter()
        getCourseResult()
    }

//    fun getAdapter(): HomeCourseAdapter{
//        return homeCourseAdapter
//    }

//    fun setAdapterData(data: ArrayList<Result>){
//        homeCourseAdapter.setDataList(data)
//        homeCourseAdapter.notifyDataSetChanged()
//    }

    fun getCourseResultDataObserver(): MutableLiveData<Course>{
        return _results
    }

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun getCourseResult() {
        coroutineScope.launch {
            val getCoursesDeferred = LearnifyApi.apiService.getCourseList("Basic $token")
            try {
                _results.value = getCoursesDeferred.await()
                _status.value = _results.value!!.results[0]
//                val listResult = getCoursesDeferred.await()
//                if (listResult.count > 0){
//                    _results.value = listResult
//                }
            }catch (t: Throwable){
                Log.d("Error", "getCourseResultF: ${t.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}