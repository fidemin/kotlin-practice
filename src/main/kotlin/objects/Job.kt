package com.yunhongmin.objects

enum class Job(
    val jobName: String,
    val salary: Int,
) {
    NO_JOB("no job", 0),
    ENGINEER("software engineer", 1),
    DUNGEON("dungeon adventure", 10),
    STUDENT("student", 0);

    fun toJobString(): String = "$jobName ($salary)"
    fun earnMoney() = when (this) {
        Job.NO_JOB, Job.STUDENT -> false
        else -> true
    }
}
