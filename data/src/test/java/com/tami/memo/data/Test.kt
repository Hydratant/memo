package com.tami.memo.data

import org.junit.Test

class Test {

    @Test
    fun test() {
        val test: Any? = "0"

        val ss: String = when (test) {
            is Int -> {
                println("Int")
                test.toString()
            }
            is String -> {
                println("String")
                test
            }
            else -> {
                println("else")
                ""
            }
        }


    }
}