package com.yunhongmin.objects

import org.intellij.lang.annotations.Language

data class Person(val name: String, val age: Int, var job: Job = Job.NO_JOB) {
    val isOld: Boolean
        get() = age > 20
}

fun printPersonInfo(person: Person): Unit {
    @Language("JSON")
    val result = """
        {
            "name": ${person.name},
            "isOld": ${person.isOld},
            "job": ${person.job.toJobString()},
            "earnMoney": ${person.job.earnMoney()}
        }
    """.trimIndent()
    println(result)
}
