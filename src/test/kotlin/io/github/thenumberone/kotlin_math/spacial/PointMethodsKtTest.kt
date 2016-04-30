package io.github.thenumberone.kotlin_math.spacial

import org.junit.Test

import org.junit.Assert.*
import java.awt.Point


class PointMethodsKtTest {
    @Test
    fun counterclockwise() {
        assertEquals(counterclockwise(Point(-1, 0), Point(0, 1), Point(1, 0)), -2.0, 0.0)
        assertEquals(counterclockwise(Point(1, 0), Point(0, 1), Point(-1, 0)), 2.0, 0.0)

        assertTrue(counterclockwise(Point(0, 0), Point(4, 5), Point(-10, 1)) > 0)
        assertTrue(counterclockwise(Point(4, 5), Point(7, 3), Point(2, 8)) > 0)

        assertEquals(counterclockwise(Point(0, 0), Point(4, 5), Point(12, 15)), 0.0, 0.0)
        assertEquals(counterclockwise(Point(-3, 6), Point(-5, 10), Point(-4, 8)), 0.0, 0.0)

        assertTrue(counterclockwise(Point(0, 0), Point(-10, 1), Point(4, 5)) < 0)
        assertTrue(counterclockwise(Point(4, 5), Point(2, 8), Point(7, 3)) < 0)
    }

    @Test
    fun plus() {
        assertEquals(Point(4, 5) + Point(1, 2), Point(5, 7))
        assertEquals(Point(-1, 4) + Point(5, -4), Point(4, 0))
    }

    @Test
    fun polarOrder() {
        val comp = Point(0, 0).polarOrder(Point(5, 6))

        assertTrue(comp.compare(Point(5, 6), Point(10, 12)) == 0)
        assertTrue(comp.compare(Point(-15, -18), Point(-5, -6)) == 0)
        assertTrue(comp.compare(Point(-10, -12), Point(10, 12)) > 0)
        assertTrue(comp.compare(Point(5, 6), Point(856, 452)) < 0)         //Doesn't matter where b is
        assertTrue(comp.compare(Point(-15,-18), Point(-1, 1)) > 0)
        assertTrue(comp.compare(Point(-15,-18), Point(3, -2)) < 0)
        assertTrue(comp.compare(Point(1451, -2452), Point(5, 6)) > 0)    //Doesn't matter where a is.
        assertTrue(comp.compare(Point(-1, 1), Point(-10, -12)) < 0)
        assertTrue(comp.compare(Point(3, -2), Point(-15, -18)) > 0)
        assertTrue(comp.compare(Point(-1, 1), Point(3, -2)) < 0)
        assertTrue(comp.compare(Point(3, -2), Point(-1, 1)) > 0)
        assertTrue(comp.compare(Point(-15,-18), Point(3, -2)) < 0)
        assertTrue(comp.compare(Point(4, 6), Point(1, 2)) < 0)
        assertTrue(comp.compare(Point(10, -3), Point(3, -6)) > 0)
    }

}