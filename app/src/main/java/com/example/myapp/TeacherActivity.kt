package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.ActivityTeachersBinding

class TeacherActivity : AppCompatActivity () {
    lateinit var binding: ActivityTeacherBinding
    private val adapter = TeacherAdapter()
    private val imageAvat = R.drawable.avatar
    private val nameTeacher = listOf("Руслан Красничук", "Вікторія Красничук", "Іван Гоянюк", "Андрій Ляшеник")
    private val index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init(){
        binding.apply {
            recyclerViewTeacher.layoutManager = LinearLayoutManager(this@TeacherActivity)
            recyclerViewTeacher.adapter = adapter

            addTeacher.setOnClickListener{
                if (index > 1) {buttonAdd.visibility = View.INVISIBLE}
                val teacher = Teacher(nameT[index], imageAvat)
                adapter.addTeacher(teacher)
                index++
            }
        }
    }
}