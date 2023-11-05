package com.example.uts

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnItemSelectedListener {
    var stores: Array<String?> = arrayOf("Cihampelas", "Cibiru", "Cianjur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storeSpinner = findViewById<Spinner>(R.id.toko_spinner)
        storeSpinner.onItemSelectedListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            stores)

        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        storeSpinner.adapter = ad

        val inputName = findViewById<EditText>(R.id.username)

        val btnSubmit: Button = findViewById(R.id.tombol_submit);
        btnSubmit.setOnClickListener {
            val selectedStore = stores.getOrNull(storeSpinner.selectedItemPosition) ?: ""
            val customerName = inputName.text.toString()

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("selectedStore", selectedStore)
            intent.putExtra("customerName", customerName)
            startActivity(intent)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {}

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}