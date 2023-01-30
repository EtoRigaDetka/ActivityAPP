package com.example.activityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.activityapp.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMain3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }

    fun onClickBack(view: View) {
        val a = getString(R.string.key3)
        intent.putExtra("$a", viewBinding.etAct3.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }

    fun onClickGet(view: View) {
        val a = getString(R.string.key2)
        viewBinding.tvMain3.text = intent.getStringExtra("$a")

    }
}