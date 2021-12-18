package com.sage.learnify.model

data class Course(
    val aggregations: List<Aggregation>,
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>,
    val search_tracking_id: String
)