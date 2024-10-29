package org.hacklord.dynamic_planner

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform