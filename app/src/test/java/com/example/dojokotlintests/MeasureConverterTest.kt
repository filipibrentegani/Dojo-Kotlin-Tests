package com.example.dojokotlintests

import io.kotlintest.matchers.bigdecimal.shouldHavePrecision
import io.kotlintest.matchers.doubles.shouldBeExactly
import io.kotlintest.specs.AnnotationSpec
import org.junit.jupiter.api.Assertions.*

class MeasureConverterTest: AnnotationSpec() {

    val measure = MeasureConverter()

    @Test
    fun `Convert Inch To Centimeter`() {
        val result = measure.convertValue(ValueType.INCH, 1.0, ValueType.CENTIMETER)
        result shouldBeExactly 2.54
    }

    @Test
    fun `Convert Centimeter To Inch`() {
        val result = measure.convertValue(ValueType.CENTIMETER, 2.54, ValueType.INCH)
        result shouldBeExactly 1.0
    }

    @Test
    fun `Convert Centimeter To Centimeter`() {
        val result = measure.convertValue(ValueType.CENTIMETER, 2.54, ValueType.CENTIMETER)
        result shouldBeExactly 2.54
    }
}