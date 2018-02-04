package com.wahib.learnkotlin.learningkotlin.other

import android.util.Log

val TAG = "MiscLearnings"

data class Football(var color: String = "")

/**
 * Apply is used to make additional configurations on a recently created object.
 * The apply() call tells us that the type of this expression is that of the object apply() is
 * invoked on, which is Football. Inside this block, this is now of type Football, which
 * allows us to call color on it directly.
 */
fun useApply() {
    val redFootball = Football("red")
    Log.i(TAG, redFootball.color)

    val patchedYellowFootball = redFootball.apply {
        color = "yellow"
    }

    Log.i(TAG, patchedYellowFootball.color)
}

class NameModifier(var name: String) {

    fun upperCase() {
        name = name.toUpperCase()
    }

    fun removeSpaces() {
        name = name.replace(" ", "")
    }
}

/**
 * A common use case for with is to call multiple methods on the same object.
 */
fun useWith() {
    val nameObj = NameModifier("Wahib Ul Haq")
    with(nameObj) {
        upperCase()
        removeSpaces()
    }

    Log.i(TAG, nameObj.name)

}

fun useDiffRanges() {
    for (i in 1..5) Log.i(TAG, i.toString())

    for (i in 6 until 11) {
        Log.i(TAG, i.toString())
    }

    for (i in 5 downTo 1) {
        Log.i(TAG, i.toString())
    }

}