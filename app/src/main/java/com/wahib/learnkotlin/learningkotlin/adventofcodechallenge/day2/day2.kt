package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day2

import android.content.Context
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer

class Day2Challenge {

    /**
     * Day2Challenge.part2(applicationContext)?.subscribe(
    { t -> output += t.toString() },
    { Log.e("error", "error") },
    { message.text = output })

     */

    companion object {

        //yes it fucking works
        fun part1(context: Context?): Observable<Int>? {

            val inputString = context?.assets?.open("input2.txt")?.bufferedReader().use {
                it?.readLines()
            }

            val numList: MutableList<List<String>> = ArrayList()

            inputString
                    ?.forEach({ row -> numList.add(row.split("\t")) })

            return Observable.fromIterable(numList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { t -> t.map { s: String -> s.toInt() } }
                    .map { t -> t.sortedDescending() }
                    .map { t: List<Int> -> t.first().minus(t.last()) }

        }

        fun part2(context: Context?): Observable<Pair<Int, Int>>? {

            val inputString = context?.assets?.open("input2.txt")?.bufferedReader().use {
                it?.readLines()
            }

            val numList: MutableList<List<String>> = ArrayList()

            val outputPairs: MutableList<Pair<Int, Int>> = ArrayList()

            inputString
                    ?.forEach({ row -> numList.add(row.split(" "))

            val baseObs = Observable.fromIterable(numList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { t -> t.map { s: String -> s.toInt() } }
                    .map { t -> t.sortedDescending() }
                    .flatMapIterable { x -> x }


            val restObs = baseObs

//            val pairs = baseObs.flatMap{n -> restObs.map { l -> Pair(n, l) }}

            baseObs.flatMap { n -> restObs.map { l -> Pair(n, l) } }
                    .filter { t: Pair<Int, Int> -> t.first != t.second &&
                    t.first.rem(t.second) == 0 }.subscribe(
                    {pair -> outputPairs.add(pair) })

             numList.clear()
                    })


            return Observable.fromIterable(outputPairs)

        }
    }
}