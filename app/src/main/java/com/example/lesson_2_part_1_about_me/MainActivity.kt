package com.example.lesson_2_part_1_about_me

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.lesson_2_part_1_about_me.databinding.ActivityMainBinding
import com.example.lesson_2_part_1_about_me.model.AppText

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appText: AppText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        appText = AppText(
            getString(R.string.emdadul_islam),
            "",
            getString(R.string.sample_bio_text),
            getString(R.string.nick_name_edit_text_hint),
            getString(R.string.done)
        )
        binding.appText = appText

        binding.btnDone.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
//            tvNickName.text = binding.etNickName.text
            this@MainActivity.appText.nickName = binding.etNickName.text.toString()
//            invalidateAll()
            etNickName.visibility = View.GONE
            view.visibility = View.GONE
            tvNickName.visibility = View.VISIBLE
        }
        //hide the keyboard
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}