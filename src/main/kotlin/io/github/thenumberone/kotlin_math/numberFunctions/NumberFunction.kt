package io.github.thenumberone.kotlin_math.numberFunctions

/**
 * Created by thenumberone on 4/25/16.
 *
 */

infix fun Int.pow(power : Int) : Int {
    if (power < 0) throw IllegalArgumentException("Power can't be negative.")
    var product = 1
    (0 until power).forEach {
        product *= this
    }
    return product
}

infix fun Int.divisibleBy(n : Int) : Boolean {
    return n != 0 && this % n == 0
}

fun sumProperDivisors(n : Int) : Int = sumDivisors(n) - n

fun sumDivisors(n: Int): Int {
    val factors = factor(n)
    var product = 1

    factors.forEach { pair ->
        var sum = 0
        (0..pair.second).forEach {
            sum += pair.first pow it
        }
        product *= sum
    }
    return product
}

fun factor(n: Int): List<Pair<Int, Int>> {
    if (n < 2) {
        return emptyList()
    }
    var number = n
    val primeFactors = mutableListOf<Pair<Int, Int>>()

    var twoCount = 0
    while (number % 2 == 0) {
        twoCount++
        number /= 2
    }
    if (twoCount > 0) {
        primeFactors.add(Pair(2, twoCount))
    }

    var i = 3
    while (i * i <= number) {
        var count = 0
        while (number % i == 0) {
            count++
            number /= i
        }
        if (count > 0) {
            primeFactors.add(Pair(i, count))
        }
        i++
    }

    if (number > 1) {
        primeFactors.add(Pair(number, 1))
    }

    return primeFactors
}
