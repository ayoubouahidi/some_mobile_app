package com.example.tp0

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputH =findViewById<TextView>(R.id.heightInput)
        val inputW = findViewById<TextView>(R.id.weightInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val button = findViewById<Button>(R.id.calculateButton)
        button.setOnClickListener {
            val textH = inputH.text.toString()
            val textW = inputW.text.toString()

            if (textW == "" || textH == "")
            {
                Toast.makeText(
                    this@MainActivity,
                    "please enter your name",
                    Toast.LENGTH_LONG).show()

            }
            else {
                fun calulateStatus(bmi :Float) :String
                {
                    if (bmi < 18.5) {
                        return "You are underweight.";
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        return "You have a normal weight.";
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        return "You are overweight.";
                    } else {
                        return "You are obese.";
                    }
                }
                val hei = textH.toFloat()
                val wei = textW.toFloat()

                val result = wei / (hei * hei)
                val bimStatus = calulateStatus(result)
                resultText.setText("$result  \n votre status est : $bimStatus ")

            }
        }





    }
}