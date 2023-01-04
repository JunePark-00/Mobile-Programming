package kr.ac.dankook.two_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        Log.d("DKMobile", "onCreate()")
        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            Log.d("DKMobile","BACK button pressed.")
            finish()
        }
    }
}