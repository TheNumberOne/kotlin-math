package io.github.thenumberone.kotlin_math.spacial

import org.junit.Test

import org.junit.Assert.*
import java.awt.Point

/**
 * Created by thenumberone on 4/28/16.
 */
class ConvexHullKtTest {
    @Test
    fun convexHull() {
        assertEquals(
                listOf(Point(-6, -6), Point(4, -4), Point(6, 0), Point(2, 6), Point(-2, 2)),
                convexHull(listOf(Point(4, 1), Point(-2, 2), Point(4, -4), Point(2, 6), Point(-5, -4), Point(6, 0), Point(-3, -3), Point(-5, -5), Point(3, -4), Point(-6, -6))))
    }

}