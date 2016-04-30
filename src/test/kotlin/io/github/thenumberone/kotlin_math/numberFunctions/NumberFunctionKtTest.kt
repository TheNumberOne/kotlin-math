package io.github.thenumberone.kotlin_math.numberFunctions

import org.junit.Test

import org.junit.Assert.*

class NumberFunctionKtTest {
    @Test
    fun pow() {
        assertEquals(5 pow 2, 25)
        assertEquals(7 pow 0, 1)
        assertEquals(16 pow 1, 16)
        assertEquals(4.pow(3), 64)
    }

    @Test
    fun sumProperDivisors() {
        assertEquals(sumProperDivisors(5), 1)   //1
        assertEquals(sumProperDivisors(12), 16) //1 + 2 + 3 + 4 + 6 = 16
        assertEquals(sumProperDivisors(6), 6)   //1 + 2 + 3 = 6
    }

    @Test
    fun sumDivisors() {
        assertEquals(sumDivisors(5), 6)      //1 + 5 = 6
        assertEquals(sumDivisors(12), 28)    //1 + 2 + 3 + 4 + 6 + 12 = 28
        assertEquals(sumDivisors(6), 12)     //1 + 2 + 3 + 6 = 12
    }

    @Test
    fun factor() {
        assertEquals(factor(5), listOf(Pair(5, 1)))              //5 = 5^1
        assertEquals(factor(12), listOf(Pair(2, 2), Pair(3, 1))) //12 = 2^2*3^1
        assertEquals(factor(16), listOf(Pair(2, 4)))             //16 = 2^4
    }

    @Test
    fun divisibleBy() {
        assertTrue(10 divisibleBy 2)
        assertFalse(54 divisibleBy 7)
    }

}