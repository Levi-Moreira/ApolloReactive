package io.apollo.sample


import org.junit.Test

import org.junit.Assert.*
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun testFormatRoundedUp() {
        val formatter = NumberFormat.getCurrencyInstance()
        formatter.minimumIntegerDigits =1
        formatter.maximumFractionDigits = 0
        formatter.roundingMode = RoundingMode.UP
        formatter.currency = Currency.getInstance("USD")
        val decimal = Math.ceil(1 / 100.toDouble())
        val value = formatter.format(decimal)
        assert(value == "$1")
    }
}