package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val intent = intent
        val selectedStore: String? = intent.getStringExtra("selectedStore")
        val customerName: String? = intent.getStringExtra("customerName")

        val topbarText = findViewById<TextView>(R.id.topbar_text)
        topbarText.text = "Hello, "+customerName.toString()

        val menuItems: Array<LinearLayout> = arrayOf(
            findViewById(R.id.menu_item_1),
            findViewById(R.id.menu_item_2),
            findViewById(R.id.menu_item_3),
            findViewById(R.id.menu_item_4)
        )

        val menuNameItems: Array<String> = arrayOf(
            "Pepperoni Pizza",
            "Spaghetti",
            "Burger",
            "Steak"
        )

        for (index in menuItems.indices) {
            val menuItem = menuItems[index]
            menuItem?.setOnClickListener {
                val intent = Intent(this, MainActivity4::class.java)
                intent.putExtra("selectedStore", selectedStore.toString())
                intent.putExtra("customerName", customerName.toString())
                intent.putExtra("menuName", menuNameItems[index])
                startActivity(intent)
            }
        }





    }
}