package com.example.tp3adapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
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
        val language= listOf(
            "java",
            "c",
            "pthon"
        )
        val liste = findViewById<ListView>(R.id.List1)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,language)
        liste.adapter = adapter
        liste.choiceMode = liste.CHOICE_MODE_MULTIPLE
    }
}