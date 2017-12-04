package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day2

import android.content.Context


object Day2FromKosta {

    /**
     *         message.text = Day2FromKosta.kick(applicationContext).toString()

     */

    private val SPACE_REGEX = """\s""".toRegex()

    fun kick(context: Context?): Int {

        val inputString = context?.assets?.open("input2.txt")?.bufferedReader().use {
            it?.readLines()
        }

        return solve2(inputString!!)

    }

    fun solve(list: Iterable<String>): Int = sumRowsBy(list, ::minmax)


    fun solve2(list: Iterable<String>): Int = sumRowsBy(list, ::dividers)

    private fun sumRowsBy(list: Iterable<String>, op: (List<Int>) -> Int): Int =
            list.sumBy {
                it.split(SPACE_REGEX)
                        .map { it.toInt() }
                        .sortedDescending()
                        .let {
                            op(it)
                        }

            }

    private fun minmax(it: List<Int>): Int = it.first() - it.last()

    private fun dividers(it: List<Int>): Int {
        it.forEachIndexed { index, i ->
            it.subList(index + 1, it.size).firstOrNull {
                i % it == 0
            }?.let {
                return i / it
            }
        }
        return 0
    }


}