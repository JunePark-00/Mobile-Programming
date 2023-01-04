package kr.ac.dankook.getreturnvaluesfromactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onStart() {
        super.onStart()

        Log.d("DKMobile", "SubActivity onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("DKMobile","SubActivity onResume()")
    }

    override fun onPause() {
        super.onPause()

        Log.d("DKMobile","SubActivity onPause()")
    }

    override fun onStop() {
        super.onStop()

        Log.d("DKMobile","SubActivity onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("DKMobile","SubActivity onDestroy()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val intentSub = intent

        val num1R = intentSub.getIntExtra("num1Extra", 0)
        val num2R = intentSub.getIntExtra("num2Extra", 0)

        Log.d("DKMobile","SubActivity onCreate()")
        Log.d("DKMobile", num1R.toString()+","+num2R.toString())

        val resultTxt = findViewById<TextView>(R.id.resultTxt)
        resultTxt.text = num1R.toString()+"+"+num2R.toString()+"="+((num1R+num2R).toString())

        val backBtn = findViewById<Button>(R.id.backBtn)

        backBtn.setOnClickListener {
            Log.d("DKMobile","Return!")
            val outIntent = Intent(this,MainActivity::class.java)
            outIntent.putExtra("result" , num1R+num2R)
            setResult(Activity.RESULT_OK, outIntent)

            finish()
        }
    }


}