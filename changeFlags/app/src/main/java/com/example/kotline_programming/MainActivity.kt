package com.example.kotline_programming

import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.constraintlayout.widget.ConstraintSet.VISIBLE
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View


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
//        buttons
//        val maroc = findViewById<RadioButton>(R.id.Tmaroc)
//        val france = findViewById<RadioButton>(R.id.Tfrance)
//        val canada = findViewById<RadioButton>(R.id.Tcanada)
//        val japan = findViewById<RadioButton>(R.id.Tjapan)
        val text = findViewById<TextView>(R.id.t1)
//        images
        val imgmaroc = findViewById<ImageView>(R.id.maroc)
        val imgfrance = findViewById<ImageView>(R.id.france)
        val imgcanada = findViewById<ImageView>(R.id.canada)
        val imgjapane = findViewById<ImageView>(R.id.japan)
        val btn1 = findViewById<RadioGroup>(R.id.btn1)

//        methode 1

        btn1.setOnCheckedChangeListener {Group, i ->
            when (i) {
                R.id.Tmaroc->{
                    imgmaroc.visibility = View.VISIBLE
                    imgfrance.visibility = View.INVISIBLE
                    imgcanada.visibility = View.INVISIBLE
                    imgjapane.visibility = View.INVISIBLE

                    text.text = "Maroc is been selected"
                }
                R.id.Tfrance->{
                    imgmaroc.visibility = View.INVISIBLE
                    imgfrance.visibility = View.VISIBLE
                    imgcanada.visibility = View.INVISIBLE
                    imgjapane.visibility = View.INVISIBLE
                    text.text = "France is been selected"
                }
                R.id.Tcanada->{
                    imgmaroc.visibility = View.INVISIBLE
                    imgfrance.visibility = View.INVISIBLE
                    imgcanada.visibility = View.VISIBLE
                    imgjapane.visibility = View.INVISIBLE
                    text.text = "Canada is been selected"
                }
                R.id.Tjapan->{
                    imgmaroc.visibility = View.INVISIBLE
                    imgfrance.visibility = View.INVISIBLE
                    imgcanada.visibility = View.INVISIBLE
                    imgjapane.visibility = View.VISIBLE
                    text.text = "Japan is been selected"
                }
            }
        }

//        if(maroc.isChecked)
//        {
//            imgmaroc.visibility = View.VISIBLE
//            text.text = "test is done !!"
//        }else if(france.isChecked)
//        {
//            imgfrance.visibility = View.VISIBLE
//        }else if(canada.isChecked)
//        {
//            imgcanada.visibility = View.VISIBLE
//        }else if(japan.isChecked)
//        {
//            imgjapane.visibility = View.VISIBLE
//        }

    }
}