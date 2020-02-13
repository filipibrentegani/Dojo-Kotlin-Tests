package com.example.dojokotlintests

class MeasureConverter {
    companion object {
        const val CONVERSION_FACTOR = 2.54
    }

    fun convertValue(
        originValueType: ValueType,
        value: Double,
        destinyValueType: ValueType
    ): Double {
        return if (originValueType == ValueType.CENTIMETER && destinyValueType == ValueType.INCH) {
            value / CONVERSION_FACTOR
        } else if (originValueType == ValueType.INCH && destinyValueType == ValueType.CENTIMETER) {
            value * CONVERSION_FACTOR
        } else
            value
    }
}

enum class ValueType {
    CENTIMETER, INCH
}