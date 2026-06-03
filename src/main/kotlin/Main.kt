package com.yunhongmin

import com.yunhongmin.objects.Person

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")
    val persons = listOf(Person("David", 24), Person("Jane", 26))

    var maxAge = 0

    for (i in 0 until persons.size) {
        val person = persons[i]
        maxAge = max(maxAge, person.age)
        println("${person.name} is old? ${person.isOld}")
    }

    println("maxAge = $maxAge")
}

fun max(a: Int, b: Int): Int =  if (a > b) a else b
