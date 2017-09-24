package com.wahib.learnkotlin.learningkotlin.util

import android.content.Context
import android.widget.Toast
import com.wahib.learnkotlin.learningkotlin.MainActivity

class Helper {

    companion object {

        fun turnToStars(value: String = "abcd"): String {
            var output = ""
            value.forEach { c -> output = output.plus("#") }
            return output
        }

        fun niceToast(context: Context,
                      message: String,
                      tag: String = MainActivity::class.java.simpleName,
                      length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, "focus on message: [$tag] -> $message", length).show()
        }

    }
}