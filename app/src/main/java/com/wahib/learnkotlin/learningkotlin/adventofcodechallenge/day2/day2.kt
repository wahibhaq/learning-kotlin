package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day2

import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Day2Challenge {

    companion object {

        //yes it fucking works
        fun part1(context: Context?): Observable<Int>? {

            val inputString = context?.assets?.open("input2.txt")?.bufferedReader().use {
                it?.readLines()
            }

            val numList: MutableList<List<String>> = ArrayList()

            inputString
                    ?.forEach( { row -> numList.add(row.split("\t"))})

            return Observable.fromIterable(numList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { t -> t.map { s: String -> s.toInt() } }
                    .map { t -> t.sortedDescending() }
                    .map { t: List<Int> -> t.first().minus(t.last()) }

        }
    }
}