package com.yunhongmin

import com.yunhongmin.objects.Job
import com.yunhongmin.objects.Person

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")
    val persons = listOf(
        Person("David", 24, Job.ENGINEER),
        Person("Jane", 26, Job.DUNGEON),
        Person("Me", 10, Job.NO_JOB)
    )

    var maxAge = 0

    for (i in 0 until persons.size) {
        val person = persons[i]
        maxAge = max(maxAge, person.age)
        println("${person.name} is old? ${person.isOld}. earn Money? ${person.job.earnMoney()}")
        person.job.printJob()
    }

    println("maxAge = $maxAge")
}

fun max(a: Int, b: Int) = if (a > b) a else b
