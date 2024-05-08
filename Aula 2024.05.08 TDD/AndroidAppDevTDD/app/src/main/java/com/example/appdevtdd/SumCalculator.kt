package com.example.appdevtdd

class SumCalculator {
    companion object {
        fun calculate(s1: String, s2: String): String {
            val num1 = s1.toInt()
            val num2 = s2.toInt()
            return (num1 + num2).toString()
        }
    }
}
