package kr.ac.dankook.app11_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.*
import android.util.Log
import android.widget.*

var started = false

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerText = findViewById<TextView>(R.id.timerText)
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        val buttonStop = findViewById<Button>(R.id.buttonStop)

        val myHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                Log.d("BkgThread","Main thread")
                if (msg.what == 1) {
                    var min = ""
                    var sec = ""
                    if(msg.arg1>9) {
                        min = msg.arg1.toString()
                    } else {
                        min = "0"+msg.arg1
                    }

                    if(msg.arg2>9){
                        sec = msg.arg2.toString()
                    } else {
                        sec = "0"+msg.arg2
                    }
                    timerText.setText("${min}:${sec}")
                    // Update timerText.text
                }
            }
        }

        Thread {
            var i = 0
            while(true) {
                Thread.sleep(1000)
                if(started){
                    i += 1
                    // Use sendMessage()
                    var msg = myHandler.obtainMessage()
                    msg.what = 1
                    msg.arg1 = i / 60
                    msg.arg2 = i % 60
                    myHandler.sendMessage(msg)
                } else {
                    i = 0
                }
            }
        }.start()

        buttonStart.setOnClickListener {
            // Do what?
            started = true
        }

        buttonStop.setOnClickListener {
            // Do what?
            started = false
        }
    }
}