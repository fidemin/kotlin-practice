package com.yunhongmin.utils


fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}
