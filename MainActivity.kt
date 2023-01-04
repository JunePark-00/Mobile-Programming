package kr.ac.dankook.app2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fileName = "internal.txt"
        val fileBody = "Testing File I/O"
        val buffo = applicationContext.openFileOutput(fileName, Context.MODE_PRIVATE)
        buffo.write(fileBody.toByteArray())
        buffo.close()
        val buffi = applicationContext.openFileInput(fileName)
        val buffr = buffi.bufferedReader()
        var txt = buffr.readLine()
        buffr.close()
        Log.d("FILETEST", "---> $txt")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = txt
    }
}