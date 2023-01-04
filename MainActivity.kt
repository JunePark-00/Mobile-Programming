package kr.ac.dankook.app11_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("kr.ac.dankook.app11_1", MODE_PRIVATE);
        val editor = sharedPref.edit()

        var username:String? = sharedPref.getString("username", "unknown")
        var password:String? = sharedPref.getString("password", "****")
        var id = sharedPref.getInt("id", -1)

        Log.d("USERDB","UserName = $username")
        Log.d("USERDB","password = $password")
        Log.d("USERDB","ID = $id")

        // ID equal 1
        if(id != -1){
            val textId = findViewById<TextView>(R.id.textId)
            val textPwd = findViewById<TextView>(R.id.textPwd)
            textId.setText(username)
            textPwd.setText(password)
            Log.d("USERDB", "Fill the text, because id = 1")
        } else {
            Log.d("USERDB", "Wait user input(username&password) ")
        }
        // ID not equal -1
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{
            editor.putString("username", findViewById<TextView>(R.id.textId).text.toString())
            editor.putString("password", findViewById<TextView>(R.id.textPwd).text.toString())
            editor.putInt("id", 1)
            editor.apply()
            Log.d("USERDB","UserName = " + sharedPref.getString("username", "unknown"))
            Log.d("USERDB","password = " + sharedPref.getString("password", "unknown"))
            Log.d("USERDB","ID = " + sharedPref.getInt("id", -1))
            Log.d("USERDB","Info Changed")
        }

    }
}