package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var carLoan: Int = 0
    private var interest: Double = 0.0
    private var monthlyRepayment: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            displayResult()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            resetFunction()
        }
    }

    private fun displayResult(){
        val textLoan = findViewById<TextView>(R.id.textViewLoan)
        val textInterest = findViewById<TextView>(R.id.textViewInterest)
        val textMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        calculation()
        val carLoanResult = carLoan.toString()
        val interestResult = interest.toString()
        val monthlyPaymentResult = monthlyRepayment.toString()

        textLoan.text = "Loan: " + carLoanResult
        textInterest.text = "Interest: " + interestResult
        textMonthlyRepayment.text = "Monthly Repayment: " + monthlyPaymentResult
    }

    private fun calculation() {
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val stringCarPrice = carPrice.text.toString()
        val intCarPrice: Int = stringCarPrice.toInt()
        val stringDownPayment = downPayment.text.toString()
        val intDownPayment: Int = stringDownPayment.toInt()
        val stringInterestRate = interestRate.text.toString()
        val doubleInterestRate: Double = stringInterestRate.toDouble()
        val stringLoanPeriod = loanPeriod.text.toString()
        val intLoanPeriod: Int = stringLoanPeriod.toInt()

        carLoan = intCarPrice - intDownPayment
        interest = doubleInterestRate - intLoanPeriod
        monthlyRepayment = (carLoan + interest) / intLoanPeriod / 12
    }

    private fun resetFunction(){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)
        val textLoan = findViewById<TextView>(R.id.textViewLoan)
        val textInterest = findViewById<TextView>(R.id.textViewInterest)
        val textMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        carPrice.text.clear()
        downPayment.text.clear()
        loanPeriod.text.clear()
        interestRate.text.clear()
        textLoan.text = "Loan: "
        textInterest.text = "Interest: "
        textMonthlyRepayment.text = "Monthly Repayment: "
    }



}
