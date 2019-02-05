package ca.adamhammer.kotlin

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Simple demonstration of Extension Functions and built-ins
 */
class FunctionalProgramming {
    /**
     * Take a CSV list of numbers and convert to a list of Ints
     */
    @Test
    fun demoExtensionFunction()
            = assertEquals("24", "24,13,15,12".fromCsv()[0])

    @Test
    fun demoExtensionFunctionWithMap()
            = assertEquals(24, "24,13,15,12"
                .fromCsv()
                .map { it.toInt() }[0])
}

private fun String.fromCsv(): List<String> = this.split(",")

