package io.github.thenumberone.kotlin_math.combinatorics

import org.junit.Test

import org.junit.Assert.*

class CombinatoricsKtTest {
    @Test
    fun ithPermutation() {
        assertEquals(listOf(0, 1, 2).ithPermutation(0), listOf(0, 1, 2))
        assertEquals(listOf(0, 1, 2).ithPermutation(1), listOf(0, 2, 1))
        assertEquals(listOf(0, 1, 2).ithPermutation(2), listOf(1, 0, 2))
        assertEquals(listOf(0, 1, 2).ithPermutation(3), listOf(1, 2, 0))
        assertEquals(listOf(0, 1, 2).ithPermutation(4), listOf(2, 0, 1))
        assertEquals(listOf(0, 1, 2).ithPermutation(5), listOf(2, 1, 0))
        assertEquals(listOf(0, 1, 2).ithPermutation(6), listOf(0, 1, 2))
    }

}