package com.yunhongmin.objects

fun String.filter(predicate: (Char) -> Boolean): String {
    StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    }
    return buildString {
        for (char in this@filter) {
            if (predicate(char)) append(char)
        }

    }
}
