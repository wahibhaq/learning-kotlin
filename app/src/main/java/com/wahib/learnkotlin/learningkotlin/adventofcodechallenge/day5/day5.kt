package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day5

import kotlin.math.absoluteValue


object Day5Challenge {

    //not really working correctly but i am too tired now
    fun part1(input: Iterable<String>): Int {
        var steps = 0
        var index = 0

        val list = input.map { it -> it.toInt() }.toMutableList()
        val iterate = list.listIterator()
        while (iterate.hasNext()) {
            val currentVal = iterate.next()
            if (currentVal < 0) {
                index = currentVal.absoluteValue
                var jumps = 0
                do {
                    iterate.hasPrevious()
                    ++jumps
                } while (jumps < index)

            } else if (currentVal > 0) {

                index = currentVal
                var jumps = 0
                do {
                    iterate.hasNext()
                    ++jumps
                } while (jumps < index)

            }

            steps++
            iterate.set(currentVal + 1)
        }

        return steps

    }

    fun solve(list: Iterable<String>): Int {
        val instr =  list.map { it.toInt() }.toMutableList()
        var n = 0
        var i = 0
        while (i < instr.size){
            n++
            i += instr[i]++
        }
        return n
    }
}