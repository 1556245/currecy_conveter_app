package com.mkaram.secondnativeproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    private val egyptionPound: String = "EgyptionPound"
    private val uAEvalue: String = "UAE"
    private val americanvalue: String = "AmericanDollar"
    private val currencyList = listOf(egyptionPound, uAEvalue, americanvalue)

    private lateinit var fromDropDownMenu: AutoCompleteTextView  // 2
    private lateinit var toDropDownMenu: AutoCompleteTextView
    private lateinit var convetBtn: Button
    private lateinit var amountField: TextInputEditText
    private lateinit var resultField: TextInputEditText

    val map = mapOf("EgyptionPound" to 21.4, "UAE" to 7.4 , "AmericanDollar" to 1.0)

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectlayouts()
        populateDropDownMenu()

        convetBtn.setOnClickListener {
            val amount: Double = amountField.text.toString().toDouble()
            val toweight = map[toDropDownMenu.text.toString()]
            val fromweight = map[fromDropDownMenu.text.toString()]
            val result= (amount * toweight!!) / fromweight!!
            resultField.setText(result.toString())
        }

    }

    private fun populateDropDownMenu() {
        val adapter = ArrayAdapter(this, R.layout.dropdownlist_item, currencyList)
        toDropDownMenu.setAdapter(adapter)
        fromDropDownMenu.setAdapter(adapter)
    }

    private fun connectlayouts() {
        fromDropDownMenu = findViewById(R.id.select_dialog_listview1)
        toDropDownMenu = findViewById(R.id.select_dialog_listview2)
        convetBtn = findViewById(R.id.convert_button)
        amountField = findViewById(R.id.textfieldbyuser)
        resultField = findViewById(R.id.resultfield)
    }
}
