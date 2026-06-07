package com.yunhongmin

import com.yunhongmin.objects.*
import com.yunhongmin.utils.joinToString
import java.lang.IO.readln

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    Person("David", 24, Job.ENGINEER).apply {
        job = Job.STUDENT
    }
    Person("Jane", 26, Job.DUNGEON)
    Person("Mike", 10, Job.NO_JOB)
    Person("Amy", 10, Job.STUDENT)

    val button = Button()
    button.click()
    button.setFocus()
    button.showOff()

    val people = PersonContainer.persons
    val sortedPeople = people.sortedWith(Person.NameComparator)

    println(sortedPeople.joinToString(separator = ", ", prefix = "Sorted People: ", postfix = " Done"))
    val maxAge = people.maxByOrNull { p -> p.age }
    println("max age: $maxAge")

    val studentMap = mutableMapOf<Int, Person>()

    for ((idx, person) in people.withIndex()) {
        println("person with $idx is registered.")
        if (person.job == Job.STUDENT) studentMap[idx] = person
    }

    val comment = "This is good"

    people.forEach {
        println(comment)
    }

    postponeComputation(5, { println("Loading...") })

    val idx = readln("Input idx: ").toInt()
    try {
        if (idx >= people.size) {
            throw IllegalArgumentException("$idx is larger than max person idx")
        }
        printPersonInfo(people[idx])
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

    interact(Fight(people[0], people[0]))
    interact(Cure(people[1], people[2]))

    Person.destroyWorld()
}

fun postponeComputation(delay: Int, computation: Runnable) {
    Thread {
        Thread.sleep(delay * 1000L)
        computation.run()
    }.start() // 별도 스레드에서 실행 — 메인 스레드 안 막음
}
