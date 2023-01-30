package com.example.activityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activityapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        var edText = viewBinding.etAct2.text.toString()
        Log.d("Mylog", "V peremennij $edText")
    }

    fun onClickMain_3(view: View) {
        val int = Intent(this, MainActivity3::class.java)
        int.putExtra("Key2", "Message to Main3 from Main2 ")
        startActivityForResult(int, 102)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(102, RESULT_OK, data)
        if (requestCode == 102 && resultCode == RESULT_OK && intent != null) {
            viewBinding.tvMain2.text = data?.getStringExtra("Key3").toString()
        } else {
            viewBinding.tvMain2.text = "Wrong request code"
        }

    }


    fun OnClickGet(view: View) {


        viewBinding.tvMain2.text = intent.getStringExtra("Key1")
        Log.d("MyLog", "Znachenie peremennoj " + intent.getStringExtra("Key1"))

    }


    fun onClickBack(view: View) {
        Log.d("MyLog", "Value Intent Back to a =" + viewBinding.etAct2.text.toString())
        var a = viewBinding.etAct2.text.toString()
        intent.putExtra("Back", viewBinding.etAct2.text.toString())
        setResult(RESULT_OK, intent)
        Log.d("MyLog", "Value Intent Back to a =" + a)
        finish()
    }
}