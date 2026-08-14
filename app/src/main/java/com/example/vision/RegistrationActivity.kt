package com.example.vision

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)

        // Set up edge-to-edge padding
        val mainView = findViewById<android.view.View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Initialize Views
        val etName = findViewById<TextInputEditText>(R.id.etRegistor_Name)
        val etPhone = findViewById<TextInputEditText>(R.id.etRegistor_Phone)
        val etEmail = findViewById<TextInputEditText>(R.id.etRegistor_Email)
        val etUsername = findViewById<TextInputEditText>(R.id.etRegistor_Username)
        val etPassword = findViewById<TextInputEditText>(R.id.etRegistor_Password)
        val etConfirmPassword = findViewById<TextInputEditText>(R.id.etRegistor_Conform_Password)
        val btnRegister = findViewById<MaterialButton>(R.id.Registor_Btn)

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
