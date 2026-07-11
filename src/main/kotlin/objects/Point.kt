package com.yunhongmin.objects

fun isFixed(): Boolean {
    println("Fixed")
    return true
}

data class Point(val x: Int, val y: Int) {
    val fixed by lazy { true }
}
