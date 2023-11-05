package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity5 : AppCompatActivity() {
    private var selectedRadioButton: RadioButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val intent = intent
        val selectedStore: String? = intent.getStringExtra("selectedStore")
        val customerName: String? = intent.getStringExtra("customerName")
        val selectedMenu: String? = intent.getStringExtra("selectedMenu")

        val orderStore: TextView = findViewById(R.id.order_store)
        orderStore.text = selectedStore

        val orderMenu: TextView = findViewById(R.id.order_menu)
        orderMenu.text = selectedMenu

        val radioGroup = findViewById<RadioGroup>(R.id.radio)

        radioGroup.clearCheck()

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedRadioButton = group.findViewById(checkedId)
        }

        val btnDone: Button = findViewById(R.id.button_done)

        btnDone.setOnClickListener {
            val terimaKasih: TextView = findViewById(R.id.pesan_terima_kasih)

            val selectedRadioText = selectedRadioButton?.text.toString()

            terimaKasih.visibility = View.VISIBLE
            terimaKasih.text = "Terima kasih $customerName sudah memesan\n" +
                    "ditoko kami, pesanan $selectedMenu\n" +
                    "anda dikirim menggunakan $selectedRadioText"
        }
    }
}