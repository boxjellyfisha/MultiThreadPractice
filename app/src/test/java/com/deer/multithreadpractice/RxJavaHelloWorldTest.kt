package com.deer.multithreadpractice

import org.junit.Test

import org.junit.Assert.*

class RxJavaHelloWorldTest {

    @Test
    fun tryThis() {
        RxJavaHelloWorld.tryThis()
    }

    @Test
    fun testObservable() {
        val rx = RxJavaHelloWorld()
        rx.main()
    }

    @Test
    fun testObservableSimple() {
        val rx = RxJavaHelloWorld()
        rx.simpleVersion()
    }
}