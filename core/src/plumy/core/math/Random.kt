package plumy.core.math

import arc.math.Mathf

fun IntRange.random(): Int = Mathf.random(start, endInclusive)
fun ClosedFloatingPointRange<Float>.random(): Float =
    Mathf.random(start, endInclusive)