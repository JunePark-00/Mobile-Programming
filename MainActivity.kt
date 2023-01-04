package kr.ac.dankook.app1

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCamera = findViewById<Button>(R.id.btnCamera)
        btnCamera.setOnClickListener {
            Log.d("DKMOBILE","CAMERA button pressed.")
            val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            if(cameraPermission == PackageManager.PERMISSION_GRANTED) {
                Log.d("DKMOBILE", "CAMERA permission already granted")
                val textpermit = findViewById<TextView>(R.id.textpermit)
                textpermit.text = "CAMERA permission already granted"
            } else {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA), 99)
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode) {
            99 -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("DKMOBILE", "CAMERA permission granted now")
                    // Do something when user grant permission.
                    val textpermit = findViewById<TextView>(R.id.textpermit)
                    textpermit.text = "CAMERA permission granted now"
                } else {
                    Log.d("DKMOBILE", "CAMERA permission not granted")
                    // Do something when user not grant permission.
                    val textpermit = findViewById<TextView>(R.id.textpermit)
                    textpermit.text = "CAMERA permission not granted"
                }
            }
        }
    }
}