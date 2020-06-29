package com.example.moviesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.view.screens.componentslist.ComponentsFragment

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
                R.id.fragmentContainer,
                ComponentsFragment()
        )
        transaction.commit()
        setContentView(R.layout.activity_main)
    }
}