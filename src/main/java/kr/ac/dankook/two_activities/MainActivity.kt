package kr.ac.dankook.two_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("DKMobile", "onCreate()")
        val intentOpen = Intent(this, SubActivity::class.java)
        val openBtn = findViewById<Button>(R.id.openBtn)
        openBtn.setOnClickListener {
            Log.d("DKMobile","OPEN SUB button pressed.")
            startActivity(intentOpen)
        }
    }
}