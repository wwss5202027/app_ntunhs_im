package com.example.a102214115_hw05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val txtTestText = findViewById<TextView>(R.id.txtTestText)
        val text =intent.getBundleExtra("key")?.getString("name").toString()

        txtTestText.setText(text)

        btnBack.setOnClickListener{
            var mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
        }

    }
    var lastTime: Long = 0
    override fun finish() {
        val currentTime = System.currentTimeMillis()
        if(currentTime - lastTime>3*1000){
            lastTime = currentTime
            Toast.makeText(this,"再按一下離開",Toast.LENGTH_SHORT).show()
        }
        else {
            super.finish()
        }
    }
}