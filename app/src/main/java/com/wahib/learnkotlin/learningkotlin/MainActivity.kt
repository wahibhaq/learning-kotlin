package com.wahib.learnkotlin.learningkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day2.Day2FromKosta
import com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day3.Day3Challenge
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private val items = listOf<String>(
            "Monday: Sunny",
            "Tuesday: Sunny",
            "Wednesday: Raining"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        message.text = "Yo Kotlin!"
//        inputPassword.setText(Helper.turnToStars())
//        Helper.niceToast(this, "sample toast")
//
//        val forecastList: RecyclerView = find(R.id.forecast_list)
//        forecastList.layoutManager = LinearLayoutManager(this)
//        forecastList.adapter = ForecastListAdapter(items)


    }


}
