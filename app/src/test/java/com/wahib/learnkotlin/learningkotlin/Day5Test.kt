package com.wahib.learnkotlin.learningkotlin

import com.wahib.learnkotlin.learningkotlin.adventofcodechallenge.day5.Day5Challenge
import org.junit.Assert
import org.junit.Test
import java.io.File


class Day5Test {

    val assetDirPath = "/Users/Wahib/Documents/git-repo/LearningKotlin/app/src/main/assets/"

    @Test
    fun task1() {

        Assert.assertEquals(5,
                Day5Challenge.solve((File(assetDirPath+"input5.txt").readLines())))
    }
}