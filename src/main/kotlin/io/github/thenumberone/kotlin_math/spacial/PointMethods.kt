package io.github.thenumberone.kotlin_math.spacial

import java.awt.geom.Point2D
import java.util.*

/**
 * Created by thenumberone on 4/28/16.
 *
 */

/**
 * Returns twice the area between points a, b, and c.
 * Result is positive if the points are in counterclockwise order.
 * Result is negative if the points are in clockwise order.
 * Result is zero if they are collinear.
 */
fun counterclockwise(a : Point2D, b : Point2D, c : Point2D) : Double {
    return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x)
}

operator fun Point2D.plus(p : Point2D) = Point2D.Double(this.x + p.x, this.y + p.y)

fun Point2D.polarOrder(p : Point2D, clockwise : Boolean = false) : Comparator<Point2D> {
    if (p == this) {
        throw IllegalArgumentException("Points can't be in same place as this. this = $this, p = $p")
    }
    fun compare(a : Point2D, b : Point2D) : Int {
        val ccwa = counterclockwise(this, p, a)
        val ccwb = counterclockwise(this, p, b)

        if (a == this || b == this) {
            throw IllegalArgumentException("Points can't be in same place as this. this = $this, p = $p, a = $a, b = $b")
        }

        val aCollinear = ccwa == 0.0
        val bCollinear = ccwb == 0.0
        if (aCollinear) {
            val aLeft = Math.signum(a.x) != Math.signum(p.x) || Math.signum(a.y) != Math.signum(p.y)
            if (bCollinear) {
                val bLeft = Math.signum(b.x) != Math.signum(p.x) || Math.signum(b.y) != Math.signum(p.y)
                if (aLeft == bLeft) {
                    return 0
                } else if (aLeft && !bLeft) { //aLeft && bRight
                    return 1
                } else {   //aRight && bLeft
                    return -1
                }
            } else if (aLeft) {
                return Math.signum(ccwb).toInt()
            } else {//!aLeft
                return -1
            }
        } else if (bCollinear) {
            val bLeft = Math.signum(b.x) != Math.signum(p.x) || Math.signum(b.y) != Math.signum(p.y)
            if (bLeft) {
                return -Math.signum(ccwa).toInt()
            } else { //!bLeft
                return 1
            }
        } else if (Math.signum(ccwa) != Math.signum(ccwb)){
            if (ccwa > 0) {
                return -1
            } else {
                return 1
            }
        } else {
            return -Math.signum(counterclockwise(this, a, b)).toInt()
        }
    }

    return Comparator { a, b ->
        compare(a, b) * if (clockwise) -1 else 1
    };
}

fun Point2D.polarOrder(clockwise : Boolean = false) =
        polarOrder(this + Point2D.Double(1.0, 0.0), clockwise)

fun Point2D.polarOrder(angle : Double, clockwise : Boolean = false) =
        polarOrder(this + Point2D.Double(Math.cos(angle), Math.sin(angle)), clockwise)

fun Point2D.polarOrder(dx : Double, dy : Double, clockwise : Boolean = false) =
        polarOrder(this + Point2D.Double(dx, dy), clockwise)