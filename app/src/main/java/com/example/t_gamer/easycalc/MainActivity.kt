package com.example.t_gamer.easycalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // TODO - FAZER CALCULOS

    private var operator: String = ""
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNumbersClickListeners()
        setOperatorsClickListeners()
    }

    private fun setNumbersClickListeners() {
        zeroBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        oneBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        twoBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        threeBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        fourBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        fiveBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        sixBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        sevenBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        eightBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
        nineBTN.setOnClickListener { appendNumbers((it as Button).text.toString()) }
    }

    private fun setOperatorsClickListeners() {
        sumBTN.setOnClickListener { appendOperator((it as Button).text.toString()) }
        lessBTN.setOnClickListener { appendOperator((it as Button).text.toString()) }
        multiplicationBTN.setOnClickListener { appendOperator((it as Button).text.toString()) }
        divisionBTN.setOnClickListener { appendOperator((it as Button).text.toString()) }
        dotBTN.setOnClickListener { appendDot() }
        clearBTN.setOnClickListener {
            clearFunctions(false)
        }
        clearBTN.setOnLongClickListener {
            clearFunctions()
            true
        }
        equalBTN.setOnClickListener { calculate() }
    }

    private fun clearFunctions(isLong: Boolean = true) {
        if (isLong) {
            operationEDT.setText("")
            resultTXT.text = ""
            operator = ""
        } else {
            if (operationEDT.text.toString().isNotEmpty()) {
                val index = operationEDT.text.toString().length
                if (operationEDT.text.toString().takeLast(index-1).equals(operator)) {
                    operator = ""
                }
                operationEDT.setText(operationEDT.text.toString().dropLast(1))
            }
        }
    }

    private fun appendDot() {

    }

    private fun appendNumbers(value: String) {
        operationEDT.append(resultTXT.text)
        operationEDT.append(value)
    }

    private fun appendOperator(value: String) {
        if (operationEDT.text.isNotEmpty()) {
            if (operator.isNotBlank() && operationEDT.text.toString().contains(operator)) {
                operationEDT.setText(operationEDT.text.toString().replace(operator, value))
            } else {
                operationEDT.append(value)
            }
            operator = value
        }
    }

    private fun calculate() {
        if (operator.isNotBlank()) {
            when (operator) {
                "+" -> sumFun()
                "-" -> lessFun()
                "*" -> multiplicationFun()
                "/" -> divideFun()
            }
        }
    }

    private fun sumFun() {

    }

    private fun lessFun() {

    }

    private fun multiplicationFun() {

    }

    private fun divideFun() {

    }
}
