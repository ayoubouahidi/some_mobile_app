package com.example.simpleadapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
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
        @SuppressLint("ResourceType")
        val lv = findViewById<ListView>(R.id.List1)
        val produit = listOf(mapOf("nom" to "p1","price" to "10dh"),
            mapOf("nom" to "p2","price" to "10dh"),
            mapOf("nom" to "p3","price" to "10dh"),
            mapOf("nom" to "p4","price" to "10dh"))
        val adapter = SimpleAdapter(this,produit,android.R.layout.simple_list_item_2, arrayOf("name","price"),
            intArrayOf(android.R.id.text1,android.R.id.text2))
        lv.adapter = adapter
    }

}
