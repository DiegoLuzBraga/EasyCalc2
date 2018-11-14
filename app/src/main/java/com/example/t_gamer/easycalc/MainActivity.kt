package com.example.t_gamer.easycalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNumbersClickListeners()
        setOperatorsClickListeners()

    }

    private fun setNumbersClickListeners() {
        zeroTXT.setOnClickListener { appendOnOperation("0", true) }
        oneTXT.setOnClickListener { appendOnOperation("1", true) }
        twoTXT.setOnClickListener { appendOnOperation("2", true) }
        threeTXT.setOnClickListener { appendOnOperation("3", true) }
        fourTXT.setOnClickListener { appendOnOperation("4", true) }
        fiveTXT.setOnClickListener { appendOnOperation("5", true) }
        sixTXT.setOnClickListener { appendOnOperation("6", true) }
        sevenTXT.setOnClickListener { appendOnOperation("7", true) }
        eightTXT.setOnClickListener { appendOnOperation("8", true) }
        nineTXT.setOnClickListener { appendOnOperation("9", true) }
    }

    private fun setOperatorsClickListeners() {
        sumTXT.setOnClickListener { appendOnOperation("+", false) }
        lessTXT.setOnClickListener { appendOnOperation("-", false) }
        multiplicationTXT.setOnClickListener { appendOnOperation("*", false) }
        divisionTXT.setOnClickListener { appendOnOperation("/", false) }
        dotTXT.setOnClickListener { appendOnOperation(".", false) }
        parenthesisLeftTXT.setOnClickListener { appendOnOperation("(", false) }
        parenthesisRightTXT.setOnClickListener { appendOnOperation(")", false) }
        clearTXT.setOnClickListener {
            operationTXT.text = ""
            resultTXT.text = ""
        }
        backspaceTXT.setOnClickListener {
            if (operationTXT.text.toString().isNotEmpty()) {
                operationTXT.text =
                        operationTXT.text.toString().removeRange(operationTXT.text.length - 1, operationTXT.text.length)
            }
        }
    }

    private fun appendOnOperation(value: String, canClear: Boolean) {
        if (canClear) {
            resultTXT.text = ""
            operationTXT.append(value)
        } else {
            operationTXT.append(resultTXT.text)
            operationTXT.append(value)
            resultTXT.text = ""
        }
    }
}
