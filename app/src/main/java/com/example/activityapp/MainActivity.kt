package com.example.activityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.activityapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }

    fun onClickGoMain2(view: View) {

        val int = Intent(this, MainActivity2::class.java) //sozdali soobwenije
        int.putExtra("Key1", "Message to Main2 from Main")
        startActivityForResult(int, 100)
    }


    fun onClickGoMain3(view: View) {
        val a = R.string.key2.toString()
        val int = Intent(this, MainActivity3::class.java)
        int.putExtra("Key2", "Message to Main3 from Main")
        startActivityForResult(int, 101)
        Log.d("My", "Value a = " + a)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(100, RESULT_OK, intent)
        if (requestCode == 100 && resultCode == RESULT_OK && intent != null) {

            Log.d("Mylog", "intent=" + intent.getStringExtra("Back"))
            viewBinding.tvMain.text = intent.getStringExtra("Back").toString()
        } else if (requestCode == 101 && resultCode == RESULT_OK && intent != null) {
            viewBinding.tvMain.text = intent.getStringExtra("Key3")
        } else {
            viewBinding.tvMain.text = "Wrong request code"
        }
    }

}