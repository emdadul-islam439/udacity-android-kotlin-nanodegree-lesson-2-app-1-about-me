package com.example.lesson_2_part_1_about_me

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_2_part_1_about_me.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvMainName.text = "hellow"
    }
}