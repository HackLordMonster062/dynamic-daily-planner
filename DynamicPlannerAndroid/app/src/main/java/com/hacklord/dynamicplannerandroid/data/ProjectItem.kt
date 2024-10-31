package com.hacklord.dynamicplannerandroid.data

data class ProjectItem(
    val title: String,
    val timelines: List<DueItem.Timeline>,
    val entityId: Int? = null
)
