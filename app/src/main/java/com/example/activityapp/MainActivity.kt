package com.example.activityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val requestCode = getString(R.string.startActivity2FromMainActivity).toInt()
        val key = getString(R.string.key1)
        val mm2 = getString(R.string.MTOM2)
        val int = Intent(this, MainActivity2::class.java)
        int.putExtra("$key", "$mm2")
        startActivityForResult(int, requestCode)
    }


    fun onClickGoMain3(view: View) {
        val requestCode = getString(R.string.startActivity3FromMainActivity).toInt()
        val key = getString(R.string.key2)
        val mm3 = getString(R.string.MTOM3)
        val int = Intent(this, MainActivity3::class.java)
        int.putExtra("$key", "$mm3")
        startActivityForResult(int, requestCode)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        val error = getString(R.string.error)
        val key = getString(R.string.key3)
        val key2 = getString(R.string.key4)
        super.onActivityResult(100, RESULT_OK, intent)
        if (requestCode == 100 && resultCode == RESULT_OK && intent != null) {

            viewBinding.tvMain.text = intent.getStringExtra("$key2").toString()
        } else if (requestCode == 101 && resultCode == RESULT_OK && intent != null) {
            viewBinding.tvMain.text = intent.getStringExtra("$key")
        } else {
            viewBinding.tvMain.text = error
        }
    }

}