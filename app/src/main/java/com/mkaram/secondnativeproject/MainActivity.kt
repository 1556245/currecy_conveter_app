package com.mkaram.secondnativeproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"
    val EgyptionPoundvalue: String = "EgyptionPound"
    val UAEvalue: String = "UAE"
    val yyyyPoundvalue: String = "AmericanDollars"
    val currencyList = listOf(EgyptionPoundvalue, UAEvalue, yyyyPoundvalue)

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val convetBtn: Button = findViewById(R.id.convert_button)
        val amountField: TextInputEditText = findViewById(R.id.textfieldbyuser)
        val resultField: TextInputEditText = findViewById(R.id.resultfield)
        val adapter = ArrayAdapter(this, R.layout.dropdownlist_item, currencyList) // 1
        val toDropDownMenu: AutoCompleteTextView = findViewById(R.id.select_dialog_listview) // 2
        toDropDownMenu.setAdapter(adapter) //3

        convetBtn.setOnClickListener {

//            Log.d(TAG, "onCreate: ${toDropDownMenu.text}")
            when (toDropDownMenu.text.toString()) { // 4
                "EgyptionPound" -> resultField.setText(
                    amountField.text.toString().toDouble().times(21.4).toString()
                )

                "UAE" -> resultField.setText(
                    amountField.text.toString().toDouble().times(7.25).toString()
                )

                "AmericanDollars" -> resultField.setText(amountField.text.toString())

            }


        }

    }

}
