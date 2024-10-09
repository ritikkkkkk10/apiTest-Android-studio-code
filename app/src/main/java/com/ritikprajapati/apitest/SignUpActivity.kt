package com.ritikprajapati.apitest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Get references to the input fields and button
        val fullNameEditText = findViewById<EditText>(R.id.etFullNameSignUp)
        val emailEditText = findViewById<EditText>(R.id.etEmailSignUp)
        val passwordEditText = findViewById<EditText>(R.id.etPasswordSignUp)
        val signUpButton = findViewById<Button>(R.id.btnSubmitSignUp)

        // Set up the Sign Up button click listener
        signUpButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Perform validation (this is just a basic example, replace it with your API call)
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
            } else {
                val request = SignUpRequest(fullName, email, password)
                signUpUser(request)
            }
        }
    }
    private fun signUpUser(request: SignUpRequest) {
        RetrofitClient.authService.signUp(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    val authResponse = response.body()
                    Toast.makeText(this@SignUpActivity, "Signed up successfully: ${authResponse?.fullName}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignUpActivity, "Failed to sign up", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Toast.makeText(this@SignUpActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
