package com.example.appdevtdd

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SumCalculatorTest {
    @Test
    fun testSumCalculatorPositiveNumbers(){
        val result = SumCalculator.calculate("2","2")
        assertEquals("4",result)
    }
    @Test
    fun testSumCalculatorNegativeNumbers(){
        val result = SumCalculator.calculate("-2","-2")
        assertEquals("-4",result)
    }
    @Test
    fun testSumCalculatorPositiveNegativeNumber(){
        val result = SumCalculator.calculate("3","-2")
        assertEquals("1",result)
    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
}