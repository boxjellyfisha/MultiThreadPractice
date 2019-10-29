package com.deer.multithreadpractice

import org.junit.Test

class SynchronizeKeywordTest {

    @Test
    fun closureTest() {
        SynchronizeKeyword().helloClosure("hello")
    }

    @Test
    fun anonymousTest() {
        SynchronizeKeyword().helloAnonymous("hello")
    }
}