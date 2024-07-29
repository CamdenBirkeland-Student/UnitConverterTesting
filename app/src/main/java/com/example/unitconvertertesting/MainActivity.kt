package com.example.unitconvertertesting

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputValue = findViewById<EditText>(R.id.inputValue)
        val inputUnit = findViewById<Spinner>(R.id.inputUnit)
        val outputUnit = findViewById<Spinner>(R.id.outputUnit)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Units for conversion
        val units = arrayOf("Celsius", "Fahrenheit", "Meters", "Centimeters", "Kilograms", "Pounds")

        // Set up the spinners with unit options
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        inputUnit.adapter = adapter
        outputUnit.adapter = adapter

        // Handle convert button click
        convertButton.setOnClickListener {
            val input = inputValue.text.toString().toDoubleOrNull()
            val inputUnitSelected = inputUnit.selectedItem.toString()
            val outputUnitSelected = outputUnit.selectedItem.toString()

            if (input != null) {
                val result = when (inputUnitSelected to outputUnitSelected) {
                    "Celsius" to "Fahrenheit" -> UnitConverter.convertTemperature(input, UnitConverter.TemperatureUnit.CELSIUS, UnitConverter.TemperatureUnit.FAHRENHEIT)
                    "Fahrenheit" to "Celsius" -> UnitConverter.convertTemperature(input, UnitConverter.TemperatureUnit.FAHRENHEIT, UnitConverter.TemperatureUnit.CELSIUS)
                    "Meters" to "Centimeters" -> UnitConverter.convertLength(input, UnitConverter.LengthUnit.METERS, UnitConverter.LengthUnit.CENTIMETERS)
                    "Centimeters" to "Meters" -> UnitConverter.convertLength(input, UnitConverter.LengthUnit.CENTIMETERS, UnitConverter.LengthUnit.METERS)
                    "Kilograms" to "Pounds" -> UnitConverter.convertWeight(input, UnitConverter.WeightUnit.KILOGRAMS, UnitConverter.WeightUnit.POUNDS)
                    "Pounds" to "Kilograms" -> UnitConverter.convertWeight(input, UnitConverter.WeightUnit.POUNDS, UnitConverter.WeightUnit.KILOGRAMS)
                    else -> null
                }

                if (result != null) {
                    resultText.text = "Result: $result"
                } else {
                    resultText.text = "Conversion not supported"
                }
            } else {
                resultText.text = "Please enter a valid number"
            }
        }
    }
}