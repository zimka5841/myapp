package com.example.myapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class GroupActivity : AppCompatActivity() {
    lateinit var binding: ActivityGroupBinding
    private val adapter = TeacherAdapter()
    private val imageAve = R.drawable.avatar
    private val nameT = listOf("П-42", "П-41", "М-42", "М-41")
    private val index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply{
            recyclerViewGroup.layoutManager = LinearLayoutManager(this@GroupActivity)
            recyclerViewGroup.adapter = adapter

            buttonAddGroup.setOnClickListener{
                if (index >= 1) {buttonAddGroup.visibility = View.INVISIBLE}
                val teacher = Teacher(nameT[index], imageAve)
                adapter.addTeacher(teacher)
                index++
            }
        }
    }
}