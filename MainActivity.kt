package kr.ac.dankook.mobile.prof.jeong.timer

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
//import androidx.activity.result.contract.ActivityResultContracts

/*
class MyHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val helloText = findViewById<TextView>(R.id.helloText)

            Log.d("BkgThread", "Main thread")
            if(msg.what == 1) {
                helloText.setText("$msg.arg1")
            }
        }
}

 */

var started = false
var paused = false

class MainActivity : AppCompatActivity() {
    /*
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

     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerText = findViewById<TextView>(R.id.timerText)
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        val buttonStop = findViewById<Button>(R.id.buttonStop)
        val buttonPause = findViewById<Button>(R.id.buttonPause)

        val sharedPref = getSharedPreferences("kr.ac.dankook.mobile.prof.jeong.timer.Shared_pref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val myHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                Log.d("BkgThread", "Main thread")
                if (msg.what == 1) {
                    val min = String.format("%02d", msg.arg1 / 60)
                    val sec = String.format("%02d", msg.arg1 % 60)
                    timerText.text = "$min:$sec"

                    if(paused){
                        editor.putString("time","$min:$sec")
                        editor.apply()
                    }
                }
            }
        }

        Thread {
            var i = 0
            while (true) {
                Thread.sleep(1000)
                if (started) {
                    i += 1
                    Log.d("BkgThread", "In background thread : $i")
                    var msg = myHandler.obtainMessage()
                    msg.what = 1
                    msg.arg1 = i
                    myHandler.sendMessage(msg)


                } else if (paused) {

                } else {
                    i = 0
                }
            }
        }.start()



        buttonStart.setOnClickListener {
            started = true
            paused = false
        }

        buttonStop.setOnClickListener {
            started = false
            paused = false
        }

        buttonPause.setOnClickListener {

            if (started) {
                started = false
            } else
                started = true

            paused = true

        }
    }
}