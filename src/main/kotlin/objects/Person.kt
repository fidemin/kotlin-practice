package com.yunhongmin.objects

import org.intellij.lang.annotations.Language

object PersonContainer {
    val persons = mutableListOf<Person>()
    fun add(person: Person) = persons.add(person)
}

data class Person(val name: String, val age: Int, var job: Job = Job.NO_JOB) {
    init {
        PersonContainer.add(this)
    }

    companion object {
        fun destroyWorld() {
            while (PersonContainer.persons.size > 0) {
                PersonContainer.persons.removeLast()
            }
        }
    }

    val isOld: Boolean
        get() = age > 20

    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person) = o1.name.compareTo(o2.name)
    }
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
