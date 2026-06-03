package com.yunhongmin.objects

class Person(val name: String, val age: Int, var job: Job = Job.NO_JOB) {
    val isOld: Boolean
        get() = age > 20
}
