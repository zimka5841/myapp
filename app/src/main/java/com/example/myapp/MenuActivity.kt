package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    fun onClickGoTeach (view: View){
        val intent = Intent (this, TeacherActivity::class.java)
        startActivity(intent)
    }
    fun onClickGoGroup (view: View){
        val intent = Intent (this, GroupActivity::class.java)
        startActivity(intent)
    }
}