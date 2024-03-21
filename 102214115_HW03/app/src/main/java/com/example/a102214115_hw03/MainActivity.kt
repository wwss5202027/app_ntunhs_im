package com.example.a102214115_hw03

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtID = findViewById<EditText>(R.id.edtID)
        val edtPW = findViewById<EditText>(R.id.edtPW)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPhone = findViewById<EditText>(R.id.edtPhone)
        val edtBirth = findViewById<EditText>(R.id.edtBirth)
        val radio_group = findViewById<RadioGroup>(R.id.radio_group)
        val chkCar = findViewById<CheckBox>(R.id.chkCar)
        val chkBike = findViewById<CheckBox>(R.id.chkBike)
        val chkMoto = findViewById<CheckBox>(R.id.chkMoto)
        val chkMRT = findViewById<CheckBox>(R.id.chkMRT)
        val btnSend = findViewById<Button>(R.id.btnSend)

        var gender = ""
        radio_group.setOnCheckedChangeListener{ _,checkedID ->
            gender = radio_group.findViewById<RadioButton>(checkedID).text.toString()
        }
        edtBirth.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this,{_,year,month,day ->
                run{
                    var format ="${setDateFormat(year,month,day)}"
                    edtBirth.setText(format)
                }
            },year,month,day).show()
        }

        btnSend.setOnClickListener {
            var vehicle = ""
            if (chkCar.isChecked()){
                vehicle += chkCar.getText().toString()+","
            }
            if (chkMoto.isChecked()){
                vehicle += chkMoto.getText().toString()+","
            }
            if (chkBike.isChecked()){
                vehicle += chkBike.getText().toString()+","
            }
            if (chkMRT.isChecked()){
                vehicle += chkMRT.getText().toString()+","
            }
            val user_message="ID:"+edtID.text.toString()+"\n"+
                             "PW:"+edtPW.text.toString()+"\n"+
                             "Name:"+edtName.text.toString()+"\n"+
                             "Email:"+edtEmail.text.toString()+"\n"+
                             "Phone:"+edtPhone.text.toString()+"\n"+
                             "Birth:"+edtBirth.text.toString()+"\n"+
                             "gender:"+gender.toString()+"\n"+
                             "vehicle:"+vehicle
            AlertDialog.Builder(this).setTitle("user").setMessage(user_message).create().show()
        }

    }
    private fun setDateFormat(year:Int,month:Int,day:Int): String{
        return "$year-$month-$day"
    }
}