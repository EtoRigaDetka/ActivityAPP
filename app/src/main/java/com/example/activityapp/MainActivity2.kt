package com.example.activityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.activityapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }

    fun onClickMain3(view: View) {
        val a = getString(R.string.key2)
        val M2M3 = getString(R.string.M2TOM3)
        val int = Intent(this, MainActivity3::class.java)
        int.putExtra("$a", "$M2M3")
        startActivityForResult(int, 102)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val err = getString(R.string.error)
        val a = getString(R.string.key3)
        super.onActivityResult(102, RESULT_OK, data)
        if (requestCode == 102 && resultCode == RESULT_OK && intent != null) {
            viewBinding.tvMain2.text = data?.getStringExtra("$a").toString()
        } else {
            viewBinding.tvMain2.text = err
        }

    }


    fun OnClickGet(view: View) {

        val a = getString(R.string.key1)
        viewBinding.tvMain2.text = intent.getStringExtra("$a")
    }


    fun onClickBack(view: View) {
        var a = getString(R.string.key4)
        intent.putExtra("$a", viewBinding.etAct2.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}