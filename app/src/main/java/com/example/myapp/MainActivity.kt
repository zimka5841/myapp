package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClickGoTwo (view : View){
        val intent = Intent(this, DrugeActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoThree (view: View){
        val intent = Intent (this, TreteActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoRegister (view: View){
        val intent = Intent (this, RegistrationActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoAuthorization (view: View){
        val intent = Intent (this, AuthorizationActivity::class.java)
        startActivity(intent)
    }

}