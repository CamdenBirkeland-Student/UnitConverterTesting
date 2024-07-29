package com.example.unitconvertertesting

import org.junit.Assert.*
import org.junit.Test

class UnitConversionTest {

    @Test
    fun testTemperatureConversion() {
        assertEquals(32.0, UnitConverter.convertTemperature(0.0, UnitConverter.TemperatureUnit.CELSIUS, UnitConverter.TemperatureUnit.FAHRENHEIT), 0.001)
        assertEquals(0.0, UnitConverter.convertTemperature(32.0, UnitConverter.TemperatureUnit.FAHRENHEIT, UnitConverter.TemperatureUnit.CELSIUS), 0.001)
    }

    @Test
    fun testLengthConversion() {
        assertEquals(1.0, UnitConverter.convertLength(100.0, UnitConverter.LengthUnit.CENTIMETERS, UnitConverter.LengthUnit.METERS), 0.001)
        assertEquals(100.0, UnitConverter.convertLength(1.0, UnitConverter.LengthUnit.METERS, UnitConverter.LengthUnit.CENTIMETERS), 0.001)
    }

    @Test
    fun testWeightConversion() {
        assertEquals(2.20462, UnitConverter.convertWeight(1.0, UnitConverter.WeightUnit.KILOGRAMS, UnitConverter.WeightUnit.POUNDS), 0.001)
        assertEquals(1.0, UnitConverter.convertWeight(2.20462, UnitConverter.WeightUnit.POUNDS, UnitConverter.WeightUnit.KILOGRAMS), 0.001)
    }
}