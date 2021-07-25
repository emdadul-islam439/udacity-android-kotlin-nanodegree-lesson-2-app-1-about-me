package com.example.lesson_2_part_1_about_me

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.lesson_2_part_1_about_me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener {
            addNickName(it)
        }
    }
    private fun addNickName(view : View){
        binding.apply {
            tvNickName.text = binding.etNickName.text
            invalidateAll()
            etNickName.visibility = View.GONE
            view.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }
        //hide the keyboard
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE)  as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}