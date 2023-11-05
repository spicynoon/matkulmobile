package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val intent = intent
        val selectedStore: String? = intent.getStringExtra("selectedStore")
        val customerName: String? = intent.getStringExtra("customerName")
        val menuName: String? = intent.getStringExtra("menuName")

        val btnOrder: Button = findViewById(R.id.btn_order_menu)
        val btnBack: Button = findViewById(R.id.btn_back)

        btnOrder.setOnClickListener{
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("selectedStore", selectedStore.toString())
            intent.putExtra("customerName", customerName.toString())
            intent.putExtra("selectedMenu", menuName.toString())
            startActivity(intent)
        }

        btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("selectedStore", selectedStore.toString())
            intent.putExtra("customerName", customerName.toString())
            startActivity(intent)
        }
    }
}