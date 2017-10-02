package com.wahib.learnkotlin.learningkotlin.other

//To Understand Custom Getter and Setter functions
class Person {

    companion object {
        fun sampleStaticFunction() {

        }
    }

    var name: String = ""
        get() = field.toUpperCase()
        set(value) {
            field = "Name: $value"
        }

    var age: String = ""
        get() = field+".0"
        set(value) {
            field = "Age: $value"
        }
}


