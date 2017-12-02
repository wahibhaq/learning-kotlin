package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day1

import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers

class Day1Challenge {

    //how to consume
    /** part 1
     *         var output: Int = 0
    //        Day1Challenge.part1(applicationContext)?.subscribe(
    //                { t -> output += t[0] },
    //                { Log.e("error", "error")},
    //                { message.text = output.toString()})
     */

    /** part 2
     * Day1Challenge.part2(applicationContext)?.subscribe(
    { t -> output += (t.first() + t.last()) },
    { Log.e("error", "error")},
    { message.text = output.toString()})
     */

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

        fun part2(context: Context?): Observable<MutableList<Int>>? {

            val inputString = context?.assets?.open("input.txt")?.bufferedReader().use {
                it?.readText()?.split("")
            }

            val numList: MutableList<Int> = ArrayList<Int>()
            inputString
                    ?.filter { s: String -> !s.equals("") }
                    ?.map { s -> s.trim().replace(",", "") }
                    ?.forEach { item: String -> numList.add(item.toInt())}

            val median: Int = numList.size/2
            val bufferSize: Int = median + 1

            return Observable.fromIterable(numList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .buffer(bufferSize, 1)
                    .filter(Predicate { buf -> buf.size == bufferSize && buf.first() == buf.last() })

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
