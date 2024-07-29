package com.example.unitconvertertesting

object UnitConverter {

    enum class TemperatureUnit { CELSIUS, FAHRENHEIT }
    enum class LengthUnit { METERS, CENTIMETERS }
    enum class WeightUnit { KILOGRAMS, POUNDS }

    fun convertTemperature(value: Double, from: TemperatureUnit, to: TemperatureUnit): Double {
        return when (from to to) {
            TemperatureUnit.CELSIUS to TemperatureUnit.FAHRENHEIT -> value * 9 / 5 + 32
            TemperatureUnit.FAHRENHEIT to TemperatureUnit.CELSIUS -> (value - 32) * 5 / 9
            else -> value
        }
    }

    fun convertLength(value: Double, from: LengthUnit, to: LengthUnit): Double {
        return when (from to to) {
            LengthUnit.METERS to LengthUnit.CENTIMETERS -> value * 100
            LengthUnit.CENTIMETERS to LengthUnit.METERS -> value / 100
            else -> value
        }
    }

    fun convertWeight(value: Double, from: WeightUnit, to: WeightUnit): Double {
        return when (from to to) {
            WeightUnit.KILOGRAMS to WeightUnit.POUNDS -> value * 2.20462
            WeightUnit.POUNDS to WeightUnit.KILOGRAMS -> value / 2.20462
            else -> value
        }
    }
}