package com.example.t_gamer.easycalc

import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_alert.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var operator: String = ""
    private var numberOfDots: Int = 0

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
        dotBTN.setOnClickListener { appendDot((it as Button).text.toString()) }
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
            numberOfDots = 0
        } else {
            if (operationEDT.text.toString().isNotEmpty()) {
                val index = operationEDT.text.toString().length
                if (operationEDT.text.toString().takeLast(index - 1).equals(operator)) {
                    operator = ""
                }
                if (operationEDT.text.toString().takeLast(index - 1).equals(".")) {
                    numberOfDots -= 1
                }
                operationEDT.setText(operationEDT.text.toString().dropLast(1))
            }
        }
    }

    private fun appendDot() {
    private fun appendDot(dot: String) {
        if (operationEDT.text.isNotEmpty()) {
            val numbers = operationEDT.text.toString().split(operator)
            if (operator.isEmpty() && ("." in numbers[0]).not() && numberOfDots.equals(0)) {
                operationEDT.text.append(dot)
                numberOfDots += 1
            } else {
                if (numbers[1].isNotEmpty() && ("." in numbers[1]).not() && numberOfDots < 1) {
                    operationEDT.text.append(dot)
                    numberOfDots += 1
                }
            }
        }
    }

    private fun appendNumbers(value: String) {
        operationEDT.append(value)
    }

    private fun appendOperator(value: String) {
        if (operationEDT.text.isNotEmpty()) {
            if (operator.isNotBlank() && operationEDT.text.toString().contains(operator)) {
                operationEDT.setText(operationEDT.text.toString().replace(operator, value))
                val alert = AlertDialog.Builder(this)
                with(alert){
                    setNegativeButton(getString(R.string.alert_negative_button)) { dialog, _ ->
                        dialog.dismiss()
                    }
                }
                val dialog = alert.create()
                dialog.setTitle(R.string.alert_title)
                dialog.run {
                    setView(layoutInflater.inflate(R.layout.activity_alert, null))
                    show()
                }
            } else {
                operationEDT.append(value)
            }
            operator = value
        }
    }

    private fun calculate() {
        resultTXT.text = ""
        val numbers = operationEDT.text.toString().split(operator)
        if (numbers.isNotEmpty()) {
            if (numbers[0].isNotBlank() && numbers[1].isNotBlank())
                if (operator.isNotBlank()) {
                    when (operator) {
                        "+" -> sumFun(numbers[0].toDouble(), numbers[1].toDouble())
                        "-" -> lessFun(numbers[0].toDouble(), numbers[1].toDouble())
                        "*" -> multiplicationFun(numbers[0].toDouble(), numbers[1].toDouble())
                        "/" -> divideFun(numbers[0].toDouble(), numbers[1].toDouble())
                    }
                }
        }
    }

    private fun sumFun(firstNumber: Double, secondNumber: Double) {
        resultTXT.text = firstNumber.plus(secondNumber).toString()
    }

    private fun lessFun(firstNumber: Double, secondNumber: Double) {
        resultTXT.text = firstNumber.minus(secondNumber).toString()
    }

    private fun multiplicationFun(firstNumber: Double, secondNumber: Double) {
        resultTXT.text = firstNumber.times(secondNumber).toString()
    }

    private fun divideFun(firstNumber: Double, secondNumber: Double) {
        resultTXT.text = firstNumber.div(secondNumber).toString()
    }
}
