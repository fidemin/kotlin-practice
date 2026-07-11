package com.yunhongmin

import com.yunhongmin.objects.*
import com.yunhongmin.utils.fail
import java.lang.IO.readln

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    val david = Person("David", 24, Job.ENGINEER).apply {
        job = Job.STUDENT
    }
    Person("Jane", 26, Job.DUNGEON)
    Person("Mike", 10, Job.NO_JOB)
    val amy = Person("Amy", 10, Job.STUDENT)
    amy.addFriend(david)

    val button = Button()
    button.click()
    button.setFocus()
    button.showOff()

    val people = PersonContainer.persons
    val sortedPeople = people.sortedWith(Person.NameComparator)
    println("- people has friends: ${people.asSequence().flatMap { it.friends }.map { it.name }.toList()}")

    val firstYoungPerson = people.asSequence().map { println("finding young person: $it}"); it.age }.find { it < 20 }
    println("- first young person age: ${firstYoungPerson ?: "None"}")

    println(
        sortedPeople.joinToString(
            separator = ", ",
            prefix = "- Sorted People: ",
            transform = { it.name })
    )
    val maxAge = people.maxByOrNull { p -> p.age }
    val totalAge = people.fold(0) { acc, person ->
        acc + person.age
    }

    println("- max age: $maxAge")
    println("- total age: $totalAge")

    val (students, notStudents) = people.partition { it.job == Job.STUDENT }

    println(
        students.joinToString(
            separator = ", ",
            prefix = "- Students: ",
            transform = { it.name })
    )
    println(
        notStudents.joinToString(
            separator = ", ",
            prefix = "- Not Students: ",
            transform = { it.name })
    )

    PersonContainer.persons.map {
        PersonProcessor(it).process()
    }

    val idx = readln("Input idx: ").toInt()
    try {
        if (idx >= people.size) {
            fail("$idx is larger than max person idx")
        }
        printPersonInfo(people[idx])
    } catch (e: Exception) {
        when (e) {
            is IllegalStateException -> println(e.toString())
            is NumberFormatException -> println("integer only available")
            else -> throw e
        }
    } finally {
        println("finally done")
    }

    postponeComputation(5, { println("Loading...") })
    interact(Fight(people[0], people[0]))
    interact(Cure(people[1], people[2]))

    Person.destroyWorld()

    val sum: (Int, Int) -> Int? = { x, y -> x + y }
    val printAction = { println(42) }

}

fun postponeComputation(delay: Int, computation: Runnable) {
    Thread {
        Thread.sleep(delay * 1000L)
        computation.run()
    }.start() // 별도 스레드에서 실행 — 메인 스레드 안 막음
}
