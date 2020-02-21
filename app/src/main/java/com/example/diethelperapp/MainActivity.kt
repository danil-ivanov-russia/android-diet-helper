package com.example.diethelperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        // Не уверен что здесь все сработает как надо, возможно нужно каким то образом проверять флаг isLoading, и если он true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}