package com.example.application_calcul_notes

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
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
        val btnC = findViewById<Button>(R.id.btn1)

        @SuppressLint("Range")
        fun mention(a: Float) {
            val Mention = findViewById<TextView>(R.id.mention)
            if (a < 10) {
                Mention.text = "Échec"
                Mention.setTextColor(Color.parseColor("#FF0000"))
            } else if (a < 12) {
                Mention.text = "Assez bien"
                Mention.setTextColor(Color.parseColor("#EEE8AA"))
            } else if (a < 14) {
                Mention.text = "bien"
                Mention.setTextColor(Color.parseColor("#FFFF00"))
            } else if (a < 16) {
                Mention.text = "tres bien"
                Mention.setTextColor(Color.parseColor("#008000"))
            } else {
                Mention.text = "Excellent"
                Mention.setTextColor(Color.parseColor("#008000"))
            }
        }

        btnC.setOnClickListener {
            val note_1 = findViewById<EditText>(R.id.ip1).text.toString().trim()
            val note_2 = findViewById<EditText>(R.id.ip2).text.toString().trim()
            val note_3 = findViewById<EditText>(R.id.ip3).text.toString().trim()
            val note_4 = findViewById<EditText>(R.id.ip4).text.toString().trim()
            val TxtR = findViewById<TextView>(R.id.Result)


            fun checkisEmty(): Int {


                if (note_1.isEmpty() || note_2.isEmpty() || note_3.isEmpty() || note_4.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        "un input ou tous les input sont vide", Toast.LENGTH_SHORT
                    ).show();
                    return 0;
                }
                return 1;
            }
            if (checkisEmty() == 1) {

                val nt1 = note_1.toFloat()
                val nt2 = note_2.toFloat()
                val nt3 = note_3.toFloat()
                val nt4 = note_4.toFloat()

                fun check(): Int {


                    if (!(nt1 >= 0 && nt1 <= 20) || !(nt2 >= 0 && nt2 <= 20) || !(nt3 >= 0 && nt3 <= 20) || !(nt4 >= 0 && nt4 <= 20)) {
                        Toast.makeText(
                            this@MainActivity,
                            "input 1 ou 2 ou 3 ou 4 est incorrect",
                            Toast.LENGTH_SHORT
                        ).show()
                        return 0;
                    }
                    return 1;

                }

                fun calcul_moy(): Float {
                    val re = (nt1 + nt2 + nt3 + nt4) / 4
                    return re
                }

                if (check() == 1) {
                    val moy = calcul_moy()
                    TxtR.text = "votre resultat est : ${moy}"
                    mention(moy)
                }
            }
        }
    }
}

