package com.smokelaboratory.backuprestore

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sharedPrefs by lazy {
        getSharedPreferences("data_store", Context.MODE_PRIVATE)
    }

    private val dataKey = "value"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUi()
        listeners()
    }

    private fun listeners() {
        bt.setOnClickListener {
            val value = et.text.toString().trim()
            if (value.isEmpty())
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.value_is_empty),
                    Toast.LENGTH_LONG
                ).show()
            else {
                sharedPrefs.edit().putString(dataKey, value).apply()
                setUi()
            }
        }
    }

    private fun setUi() {
        tv.text = getString(
            R.string.stored_value_x, if (sharedPrefs.contains(dataKey))
                sharedPrefs.getString(dataKey, "") else ""
        )
    }
}
