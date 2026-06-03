package com.yunhongmin

import com.yunhongmin.objects.Job
import com.yunhongmin.objects.Person
import com.yunhongmin.utils.joinToString
import org.intellij.lang.annotations.Language
import java.lang.IO.readln

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
        Person("Mike", 10, Job.NO_JOB),
        Person("Amy", 10, Job.STUDENT)
    )

    println(persons.joinToString(separator = ", ", prefix = "Persons: ", postfix = " Done"))

    val studentMap = mutableMapOf<Int, Person>()

    for ((idx, person) in persons.withIndex()) {
        println("person with $idx is registered.")
        if (person.job == Job.STUDENT) studentMap[idx] = person
    }

    val idx = readln("Input idx: ").toInt()
    try {
        if (idx >= persons.size) {
            throw IllegalArgumentException("$idx is larger than max person idx")
        }
        printPersonInfo(persons[idx])
        if (idx in studentMap) {
            println("This person is student")
        }
    } catch (e: Exception) {
        when (e) {
            is IllegalStateException -> println(e.toString())
            is NumberFormatException -> println("integer only available")
            else -> throw e
        }
    } finally {
        println("finally done")
    }
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun printPersonInfo(person: Person): Unit {
    @Language("JSON")
    val result = """
        {
            "name": ${person.name},
            "isOld": ${person.isOld},
            "job": ${person.job.name},
            "earnMoney": ${person.job.earnMoney()}
        }
    """.trimIndent()
    println(result)
    person.job.printJob()
}
