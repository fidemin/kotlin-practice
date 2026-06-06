package com.yunhongmin.objects

sealed class Interaction
class Fight(val person1: Person, val person2: Person) : Interaction()
class Cure(val doctor: Person, val patient: Person) : Interaction()

fun interact(interaction: Interaction): Unit =
    when (interaction) {
        is Fight -> println("${interaction.person1.name} fights with ${interaction.person2.name}")
        is Cure -> println("${interaction.doctor.name} cures ${interaction.patient.name}")
    }
