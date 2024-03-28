package com.example.a102214115_hw05

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnChangeActivity)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)
        val edtName = findViewById<TextView>(R.id.edtNameText)

        btnChangeActivity.setOnClickListener{
            var bundle =Bundle()
            var name = edtName.text.toString()
            bundle.putString("name",name)

            var secondIntent = Intent(this,SecondActivity::class.java)
            secondIntent.putExtra("key",bundle)
            startActivity(secondIntent)
        }

        btnOpenBrowser.setOnClickListener{
            var secondIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
            startActivity(secondIntent)
        }


    }
}