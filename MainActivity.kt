package kr.ac.dankook.getreturnvaluesfromactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts. StartActivityForResult()) { res->
            if(res.resultCode == Activity.RESULT_OK){
                val value = res.data?.getIntExtra("result", 0)
                Log.d("DKMobile", "Received Result is "+value. toString())
                val mainResultView = findViewById<TextView>(R.id.mainResultTxt)
                mainResultView.text = "Result is "+value.toString()
            }
        }

    override fun onStart() {
        super.onStart()

        Log.d("DKMobile", "MainActivity onStart()")
    }

    override fun onResume() {
        super.onResume()

        Log.d("DKMobile","MainActivity onResume()")
    }

    override fun onPause() {
        super.onPause()

        Log.d("DKMobile","MainActivity onPause()")
    }

    override fun onStop() {
        super.onStop()

        Log.d("DKMobile","MainActivity onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("DKMobile","MainActivity onDestroy()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("DKMobile","MainActivity onCreate()")
        val intentOpen = Intent(this, SubActivity::class.java)
        val openBtn = findViewById<Button>(R.id.openBtn)
        openBtn.setOnClickListener {
            Log.d("DKMobile","Click to open sub activity")
            val num1W = findViewById<EditText>(R.id.num1)
            val num2W = findViewById<EditText>(R.id.num2)
            val num1 = num1W.text.toString().toInt()
            val num2 = num2W.text.toString().toInt()
            Log.d("DKMobile",num1.toString()+","+num2.toString())
            intentOpen.putExtra("num1Extra",num1)
            intentOpen.putExtra("num2Extra",num2)

            //startActivity(intentOpen)
            getResult.launch(intentOpen)
        }
    }
}