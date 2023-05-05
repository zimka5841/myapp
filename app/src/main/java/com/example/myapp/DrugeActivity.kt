package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class DrugeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_druge)
    }
    fun onClickGoThree (view : View){
        val intent = Intent(this, TreteActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoMain (view: View){
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }

}