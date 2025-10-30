package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

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
        Log.d("MainActivity", "Aplikasi berhasil Dijalankan!")

        val etUsername: EditText = findViewById(R.id.et_username)
        val btnDaftar: Button = findViewById(R.id.btn_daftar)
        val btnLogin: Button = findViewById(R.id.btn_login)

        btnDaftar.setOnClickListener {
            val username = etUsername.text.toString()
            val intent = Intent(this, HomeActivity::class.java)

            intent.putExtra("EXTRA_USERNAME", username)
            startActivity(intent)

            btnDaftar.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}