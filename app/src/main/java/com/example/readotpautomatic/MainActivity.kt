package com.example.readotpautomatic

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    private val CAMERA_PERMISSION_CODE = 123

    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(
            this,
            arrayOf("android.permission.RECEIVE_SMS"),
            CAMERA_PERMISSION_CODE
        )
        editText=findViewById(R.id.editTextOtp)
        val otpReceiver =OTP_RECEIVER()
        otpReceiver.setEditText(editText)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==CAMERA_PERMISSION_CODE){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permission is Granted",Toast.LENGTH_SHORT).show()
            }
            else{
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf("android.permission.RECEIVE_SMS"),
                    CAMERA_PERMISSION_CODE
                )
            }
        }
    }
}