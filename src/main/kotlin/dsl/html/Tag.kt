package com.yunhongmin.dsl.html

interface Node

class TextNode(val text: String) : Node {
    override fun toString(): String = text
}

open class Tag(val name: String) : Node {
    private val children = mutableListOf<Node>()


    protected fun <T : Node> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    operator fun String.unaryPlus() {
        children.add(TextNode(this))
    }

    override fun toString(): String = "<$name>${children.joinToString("")}</$name>"
}

fun html(init: Html.() -> Unit) = Html().apply(init)

class Html : Tag(name = "html") {
    fun body(init: Body.() -> Unit) = doInit(Body(), init)
}

class Body : Tag(name = "body")
