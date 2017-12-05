package com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day4

import android.content.Context


object Day4Challenge {

    fun part1(context: Context?): Int {

        val inputString = context?.assets?.open("input4.txt")?.bufferedReader().use {
            it?.readLines()
        }

        return getAnswer(inputString!!)

    }

    fun part2(context: Context?): Int {
        val inputString = context?.assets?.open("input4.txt")?.bufferedReader().use {
            it?.readLines()
        }

        return getAnswer2(inputString!!)
    }

    fun getAnswer(inputList: Iterable<String>): Int {
        return inputList.sumBy {
            it.split(" ")
                    .let {
                        if(isPassphraseCorrect(it)) 1 else 0
                    }
        }
    }

    fun isPassphraseCorrect(phraseToVerify: Iterable<String>): Boolean {
        val mySet: MutableSet<String> = HashSet()
        mySet.addAll(phraseToVerify)
        return mySet.size == phraseToVerify.count()
    }

    fun getAnswer2(inputList: Iterable<String>): Int {
        return inputList.count { isPassphraseCorrect2(it) }
    }

    fun isPassphraseCorrect2(phraseToVerify: String): Boolean {
        val mySet = HashSet<String>()

        phraseToVerify.split(" ").forEach {
            mySet.add(it.toCharArray().sorted().toString())
        }
        return mySet.size == phraseToVerify.split(" ").count()
    }

}