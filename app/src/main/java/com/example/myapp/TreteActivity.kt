package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TreteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trete)
    }
    fun onClickGoMain (view: View){
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoTwo (view : View){
        val intent = Intent(this, DrugeActivity::class.java)
        startActivity(intent)
    }


}