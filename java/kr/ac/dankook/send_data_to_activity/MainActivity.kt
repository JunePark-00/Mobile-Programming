package kr.ac.dankook.send_data_to_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("DKMobile","onCreate()")
        val intentOpen = Intent(this, SubActivity::class.java)
        val openBtn = findViewById<Button>(R.id.openBtn)
        openBtn.setOnClickListener {
            Log.d("DKMobile","Click to open sub activity")
            val num1W = findViewById<EditText>(R.id.num1)
            val num2W = findViewById<EditText>(R.id.num2)
            val num1 = num1W.text.toString().toInt()
            val num2 = num2W.text.toString().toInt()
            Log.d("DKMobile",num1.toString()+", "+num2.toString())
            intentOpen.putExtra("num1Extra",num1)
            intentOpen.putExtra("num2Extra",num2)

            startActivity(intentOpen)
        }
    }
}