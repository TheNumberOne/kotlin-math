package io.github.thenumberone.kotlin_math.primality

import org.junit.Test

import org.junit.Assert.*


class PrimalityKtTest {
    @Test
    fun isPrime() {
        assertTrue(isPrime(5))
        assertFalse(isPrime(10))
        assertFalse(isPrime(0))
        assertFalse(isPrime(1))
        assertTrue(isPrime(2))
        assertFalse(isPrime(259))
        assertTrue(isPrime(97))
    }

}