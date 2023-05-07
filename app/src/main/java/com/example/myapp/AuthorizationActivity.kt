package com.example.myapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AuthorizationActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var loginEdit: EditText
    private lateinit var passwordEdit: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        loginEdit = findViewById(R.id.login_edit)
        passwordEdit = findViewById(R.id.password_edit)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val login = loginEdit.text.toString()
            val password = passwordEdit.text.toString()
            if (checkCredentials(login, password)) {
                saveCredentials(login, password)
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("login", login)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Incorrect login or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkCredentials(login: String, password: String): Boolean {

        if (login != "") {
            if (sharedPreferences.contains(login)) {
                if (sharedPreferences.getString(login, "") == password) {
                    return true

                }
            }
        }
        return false
    }

    private fun saveCredentials(login: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("login", login)
        editor.putString("password", password)
        editor.apply()
    }
}