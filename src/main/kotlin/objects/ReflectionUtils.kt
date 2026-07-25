package com.yunhongmin.objects

import kia.jkid.serialization.serialize
import kotlin.reflect.full.memberProperties


fun practiceReflection() {
    val person = Person(name = "Yunhong", age = 10)
    val friend = Person(name = "yourFriend", age = 11)
    val kClass = person::class

    kClass.memberProperties.forEach { println(it.name) }
    kClass.members.forEach { println(it.name) }

    val addFriendKFunc = person::addFriend
    addFriendKFunc.call(friend)
    println(person.friends)
    println(serialize(person))
}
