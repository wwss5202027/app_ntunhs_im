package com.example.a102214115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.textView)
        val ans = findViewById<TextView>(R.id.ans)
        val result_textView = findViewById<TextView>(R.id.result_textView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validata_num:Int

        var secret : Int = Random().nextInt(100)+1
        var max :Int = 100
        var min :Int = 0

        guess_button.setOnClickListener{

//            Toast.makeText(this,editText.text,Toast.LENGTH_LONG).show()
//            AlertDialog.Builder(this).setTitle("onclick").setMessage("onclick").create().show()

            validata_num=editText.text.toString().toInt()-secret
            var ans_str:String="你猜對了喔"

            if (validata_num>0){
                max=editText.text.toString().toInt()
                ans_str=min.toString()+"-"+max.toString()

            }
            else if(validata_num<0){
                min=editText.text.toString().toInt()
                ans_str=min.toString()+"-"+max.toString()
            }
            textView.text=ans_str
            ans.text=secret.toString()
        }
        reset_button.setOnClickListener{
            secret= Random().nextInt(100)+1
            textView.text="我們再猜一次"
            ans.text="答案:"+secret.toString()
        }
    }

}