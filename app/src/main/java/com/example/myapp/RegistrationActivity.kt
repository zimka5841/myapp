package com.example.myapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var emailEditText: EditText
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        emailEditText = findViewById(R.id.edit_email)
        loginEditText = findViewById(R.id.edit_login)
        passwordEditText = findViewById(R.id.edit_pass)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        val registerButton = findViewById<Button>(R.id.regButton)
        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Перевірка довжини логіну та паролю
            if (login.length < 4) {
                loginEditText.error = "Логін повинен містити як мінімум 4 символа"
                return@setOnClickListener
            }
            if (password.length < 4) {
                passwordEditText.error = "Пароль повинен містити як мінімум 4 символа"
                return@setOnClickListener
            }

            // Перевірка, чи логін не зайнятий
            val userExists = sharedPreferences.getString(login, null)
            if (userExists != null) {
                loginEditText.error = "Такий користувач вже існує"
                return@setOnClickListener
            }

            saveCredentials(email, login, password)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("login", login)
            startActivity(intent)
            finish()
        }
    }

    private fun saveCredentials(email: String, login: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString(login, password)
        editor.apply()
    }
}