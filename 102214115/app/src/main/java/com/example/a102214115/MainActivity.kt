package com.example.a102214115

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*


class MainActivity : AppCompatActivity() {

    val TAG:String = MainActivity::class.java.simpleName
    private lateinit var handler:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)
        handler = Handler(Looper.getMainLooper())




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


        ans.text="答案:"+secret.toString()
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
            ans.text="答案:"+secret.toString()
            handler.postDelayed({
                Toast.makeText(this,"6秒後的操作執行了",Toast.LENGTH_SHORT).show()
                secret= Random().nextInt(100)+1
                textView.text="我們再猜一次"
                ans.text="答案:"+secret.toString()
                                },6000)

        }
        reset_button.setOnClickListener{
            secret= Random().nextInt(100)+1
            textView.text="我們再猜一次"
            ans.text="答案:"+secret.toString()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}