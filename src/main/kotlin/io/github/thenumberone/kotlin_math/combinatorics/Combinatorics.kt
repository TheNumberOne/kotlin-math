package io.github.thenumberone.kotlin_math.combinatorics

import java.util.*

/**
 * Created by thenumberone on 4/25/16.
 *
 */

fun <T> List<T>.ithPermutation(i : Int) : List<T> {
    var index = i
    var factorialBase = Stack<Int>()

    for (j in 1..this.size) {
        factorialBase.push(index % j)
        index /= j
    }
    val mutableThis = toMutableList()
    val permutation = mutableListOf<T>()

    while(!factorialBase.empty()) {
        permutation.add(mutableThis[factorialBase.peek()])
        mutableThis.removeAt(factorialBase.pop())
    }

    return permutation
}