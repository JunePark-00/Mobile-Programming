package kr.ac.dankook.app11_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDB::class. java, "userdb"
        ).allowMainThreadQueries().build()
        
        val users = db.userDao().getAll()

        if(users. isNotEmpty()) {

            Log.d("USERDB","Something in db")

            var readuser = db.userDao().findByName("W%", "%")

            if (readuser != null) {
                Log.d("USERDB","Find Data")
            } else {
                Log.d("USERDB","Find failed")
            }
        } else {
            Log.d("USERDB","Nothing in db")
            val userd = User(1, "Jueun", "Park")
            db.userDao().insertAll(userd)
            Log.d("USERDB", "Insert all data in DB")
        }
    }
}