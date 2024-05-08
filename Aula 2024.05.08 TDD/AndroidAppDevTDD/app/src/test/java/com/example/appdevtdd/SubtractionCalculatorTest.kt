package com.example.appdevtdd

import org.junit.Assert
import org.junit.Test

class SubtractionCalculatorTest {
    @Test
    fun testSubtractionCalculatorPositiveNumbers(){
        val result = SubtractionCalculator.calculate("2","2")
        Assert.assertEquals("0", result)
    }
    @Test
    fun testSubtractionCalculatorNegativeNumbers(){
        val result = SubtractionCalculator.calculate("-2","-4")
        Assert.assertEquals("2", result)
    }
    @Test
    fun testSubtractionCalculatorPositiveNegativeNumber(){
        val result = SubtractionCalculator.calculate("3","-2")
        Assert.assertEquals("5", result)
    }
}