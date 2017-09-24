package com.wahib.learnkotlin.learningkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wahib.learnkotlin.learningkotlin.util.Helper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Yo Kotlin!"
        inputPassword.setText(Helper.turnToStars())
        Helper.niceToast(this, "sample toast")
    }

}
