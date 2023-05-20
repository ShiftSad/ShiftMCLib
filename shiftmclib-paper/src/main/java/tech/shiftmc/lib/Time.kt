package tech.shiftmc.lib

fun convertMillisToText(millis: Long, units: Map<String, Long> = mapOf(
    "day" to 86400000L,
    "hour" to 3600000L,
    "minute" to 60000L,
    "second" to 1000L
)): String = run {
    var dummy = millis
    return units.mapNotNull { (unit, value) ->
        val count = dummy / value
        dummy %= value
        if (count > 0) "$count $unit${if (count > 1) "s" else ""}" else null
    }.joinToString(", ").ifEmpty { "0 seconds" }
}

