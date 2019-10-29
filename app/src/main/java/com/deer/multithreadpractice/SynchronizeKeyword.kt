package com.deer.multithreadpractice

class SynchronizeKeyword {

    private var lock: Boolean = false
    private var criticalVar: String = "Hi, there is Kelly."


    private var testString = "start closure"

    fun helloClosure(passStr: String) {
        {
            testString = "end closure"
        }.invoke()
        System.out.println(testString)
        System.out.println(passStr)
    }

    interface MyAnonymous {
        fun heyYou()
    }

    fun helloAnonymous(passStr: String) {
        object : MyAnonymous {
            override fun heyYou() {
                testString = "end Anonymous"
                helloClosure("block")
            }
        }.heyYou()
        System.out.println(testString)
    }
}