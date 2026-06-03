package com.yunhongmin.objects

class Person(val name: String, val age: Int) {
    val isOld: Boolean
        get() = age > 20
}
