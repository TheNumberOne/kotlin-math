package io.github.thenumberone.kotlin_math.primality

import io.github.thenumberone.kotlin_math.numberFunctions.divisibleBy

/**
 * Created by thenumberone on 4/27/16.
 *
 */

fun isPrime(n : Int) : Boolean {
    if (n == 2) return true
    if (n < 2 || n divisibleBy 2) return false

    var j = 3
    while (j * j <= n) {
        if (n divisibleBy j) return false
        j += 2
    }

    return true
}