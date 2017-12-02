package com.wahib.learnkotlin.learningkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.wahib.learnkotlin.learningkotlin.Adapter.ForecastListAdapter
import com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day1.Day1Challenge
import com.wahib.learnkotlin.learningkotlin.util.Helper
import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.internal.observers.ForEachWhileObserver
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

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

        var output: Int = 0
        Day1Challenge.part1(applicationContext)?.subscribe(
                { t -> output += t[0] },
                { Log.e("error", "error")},
                { message.text = output.toString()})


//        message.text = Day1Challenge.solvePart1(applicationContext).toString()




    }



}
