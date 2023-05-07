package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TeacherAdapter: RecyclerView.Adapter<TeacherAdapter.TeacherHolder>() {
    val teacherList = ArrayList<Teacher>()

    class TeacherHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = TeacherItemBinding.bind(item)
        fun bind(teacher: Teacher) = with(binding){
            teacherName.text = teacher.Name
            avaTar.setImageResource(teacher.Image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item, parent, false)
        return TeacherHolder(view)
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    override fun onBindViewHolder(holder: TeacherHolder, position: Int) {
        holder.bind(teacherList[position])
    }
    fun addTeacher(teacher: Teacher){
        teacherList.add(teacher)
        notifyDataSetChanged()
    }
}