package com.sage.learnify.model

import com.google.gson.annotations.SerializedName

data class ApiCourseResponse(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("aggregations")
	val aggregations: List<AggregationsItem?>? = null,

	@field:SerializedName("search_tracking_id")
	val searchTrackingId: String? = null
)

data class ResultsItem(

	@field:SerializedName("visible_instructors")
	val visibleInstructors: List<VisibleInstructorsItem?>? = null,

	@field:SerializedName("lecture_search_result")
	val lectureSearchResult: Any? = null,

	@field:SerializedName("published_title")
	val publishedTitle: String? = null,

	@field:SerializedName("price_serve_tracking_id")
	val priceServeTrackingId: String? = null,

	@field:SerializedName("image_480x270")
	val image480x270: String? = null,

	@field:SerializedName("predictive_score")
	val predictiveScore: Any? = null,

	@field:SerializedName("input_features")
	val inputFeatures: Any? = null,

	@field:SerializedName("order_in_results")
	val orderInResults: Any? = null,

	@field:SerializedName("curriculum_items")
	val curriculumItems: List<Any?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("image_125_H")
	val image125H: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("price_detail")
	val priceDetail: Any? = null,

	@field:SerializedName("image_240x135")
	val image240x135: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("curriculum_lectures")
	val curriculumLectures: List<Any?>? = null,

	@field:SerializedName("is_practice_test_course")
	val isPracticeTestCourse: Boolean? = null,

	@field:SerializedName("instructor_name")
	val instructorName: Any? = null,

	@field:SerializedName("_class")
	val _class: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("is_paid")
	val isPaid: Boolean? = null,

	@field:SerializedName("headline")
	val headline: String? = null,

	@field:SerializedName("tracking_id")
	val trackingId: String? = null,

	@field:SerializedName("relevancy_score")
	val relevancyScore: Any? = null
)

data class VisibleInstructorsItem(

	@field:SerializedName("initials")
	val initials: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("image_50x50")
	val image50x50: String? = null,

	@field:SerializedName("_class")
	val _class: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("display_name")
	val displayName: String? = null,

	@field:SerializedName("image_100x100")
	val image100x100: String? = null,

	@field:SerializedName("job_title")
	val jobTitle: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class OptionsItem(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class AggregationsItem(

	@field:SerializedName("options")
	val options: List<OptionsItem?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
