package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbAgree = findViewById<CheckBox>(R.id.cbAgree)
        val btnRegister = findViewById<Button>(R.id.btn_submit_register)

        btnRegister.setOnClickListener {
            val selectedId = rgGender.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadio = findViewById<RadioButton>(selectedId)
                val gender = when (selectedRadio.id) {
                    R.id.rbPria -> "Pria"
                    R.id.rbWanita -> "Wanita"
                    else -> "Tidak diketahui"
                }
                val isAgree = cbAgree.isChecked

                Toast.makeText(
                    this,
                    "Jenis Kelamin: $gender\nSetuju: $isAgree",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, "Pilih jenis kelamin terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}