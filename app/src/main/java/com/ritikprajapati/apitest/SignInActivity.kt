package com.ritikprajapati.apitest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Callback
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Get references to the input fields and button
        val emailEditText = findViewById<EditText>(R.id.etEmailSignIn)
        val passwordEditText = findViewById<EditText>(R.id.etPasswordSignIn)
        val signInButton = findViewById<Button>(R.id.btnSubmitSignIn)

        // Set up the Sign In button click listener
        signInButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Perform validation (this is just a basic example, replace it with your API call)
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
            } else {
                val request = SignInRequest(email, password)
                signInUser(request)
            }
        }
    }

    private fun signInUser(request: SignInRequest) {
        RetrofitClient.authService.signIn(request).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {
                    val authResponse = response.body()
                    Toast.makeText(this@SignInActivity, "Signed in successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignInActivity, "Failed to sign in", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Toast.makeText(this@SignInActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
