package com.yunhongmin.dsl.html

open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit): T {
        child.init()
        children.add(child)
        return child
    }

    override fun toString(): String = "<$name>${children.joinToString("")}</$name>"
}

fun html(init: Html.() -> Unit) = Html().apply(init)

class Html : Tag(name = "html") {
    fun body(init: Body.() -> Unit) = doInit(Body(), init)
}

class Body : Tag(name = "body")
