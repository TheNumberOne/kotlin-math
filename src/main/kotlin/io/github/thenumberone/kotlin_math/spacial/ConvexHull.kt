package io.github.thenumberone.kotlin_math.spacial

import java.awt.geom.Point2D
import java.util.*
import java.util.function.Function

/**
 * Created by thenumberone on 4/27/16.
 *
 */

fun convexHull(points : Iterable<Point2D>) : List<Point2D> = convexHull(points.toList().toTypedArray())

fun convexHull(points : Array<Point2D>) : List<Point2D> {
    if (points.size <= 1) {
        return points.toList()
    }
    val firstIndex = points.indices.minWith(
            Comparator.comparing(
                    Function { index -> points[index] },
                    Comparator.comparingDouble<Point2D> { p -> p.y }
                            .thenComparingDouble { p -> p.x }))!!

    val first = points[firstIndex]
    points[firstIndex] = points[0]
    points[0] = first

    points.sortWith(first.polarOrder(), 1)

    val hull = LinkedList<Point2D>()
    hull.add(first)

    for (i in 1 until points.size) {
        val p = points[i]
        var top = hull.peek()
        var previous : Point2D? = if (hull.size <= 1) null else hull[1]
        while (previous != null && counterclockwise(previous, top, p) <= 0) { //While the 3 points are clockwise.
            hull.pop()
            top = previous
            previous = if (hull.size <= 1) null else hull[1]
        }
        hull.push(p)
    }

    while (hull.size > 3 && counterclockwise(hull.get(1), hull.peek(), first) <= 0) {
        hull.pop()
    }

    return hull.reversed()

}