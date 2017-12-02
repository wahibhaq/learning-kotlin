package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day1

import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers

class Day1Challenge {

    companion object {

        //yes it fucking works
        fun part1(context: Context?): Observable<MutableList<Int>>? {

            val inputString = context?.assets?.open("input.txt")?.bufferedReader().use {
                it?.readText()?.split("")
            }

            val numList: MutableList<Int> = ArrayList<Int>()
            inputString
                    ?.filter { s: String -> !s.equals("") }
                    ?.map { s -> s.trim().replace(",", "") }
                    ?.forEach { item: String -> numList.add(item.toInt())}
            
            return Observable.fromIterable(numList + numList.first())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .buffer(2, 1)
                    .filter(Predicate { buf -> buf.size == 2 && buf[0] == buf[1] })

        }

        //copied from reddit and worked fine
        fun solvePart1(context: Context?): Int {

            val inputString = context?.assets?.open("input.txt")?.bufferedReader().use {
                it?.readText()?.split("")
            }

            val numList: MutableList<Int> = ArrayList<Int>()
            inputString
                    ?.filter { s: String -> !s.equals("") }
                    ?.map { s -> s.trim().replace(",", "") }
                    ?.forEach { item: String -> numList.add(item.toInt())}

            return (numList + numList[0])   // Circular list, re-add [0] to the end so they pair up.
                    .zipWithNext()
                    .filter { it.first == it.second }
                    .map { it.first}
                    .sum()

        }


    }

}
