package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day3

import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer


class Day3Challenge {

    /**
     *         var output = ""
    Day3Challenge.part1(applicationContext)?.subscribe(
    { t -> output = t.toString()},
    { Log.e("error", "error") },
    { message.text = output })
     */

    companion object {

        fun part1(context: Context?): Observable<Int>? {

            val inputString = context?.assets?.open("input3.txt")?.bufferedReader().use {
                it?.readText()
            }

            val input = inputString?.toInt()

            return Observable.just(calculateShit(input!!))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

        fun base(x: Int) : Int {
            return (Math.floor(Math.sqrt(x.toDouble()))).toInt()
        }

        fun findClosestBase(x: Int): Int {
            val sqrtx = base(x)
            return if (sqrtx % 2 != 0) {
                sqrtx
            } else {
                sqrtx - 1
            }
        }

        fun findLeastTransposedNumber(baseNumber: Int, x: Int) : Int {
            return if ((x - baseNumber) > (baseNumber * baseNumber)) {
                findLeastTransposedNumber(baseNumber, x - baseNumber - 1)
            } else {
                x
            }
        }

        fun getNumOfStepsToLeft(baseNumber: Int) = (baseNumber - 1)/2

        fun findSpiralVerticalMedian(baseNumber: Int) = (baseNumber * baseNumber) + ((baseNumber + 1)/2)

        fun getVerticalSteps(verticalCenter: Int, leastTranspsedX: Int) = Math.abs(verticalCenter - leastTranspsedX)

        fun calculateShit(input: Int) : Int {
            val baseNumber = findClosestBase(input)
            val leastTransposedX = findLeastTransposedNumber(baseNumber, input)
            val verticalCenter = findSpiralVerticalMedian(baseNumber)
            val verticalSteps = getVerticalSteps(verticalCenter, leastTransposedX)
            val horizontalSteps = getNumOfStepsToLeft(baseNumber) + 1


            return verticalSteps + horizontalSteps
        }



    }
}