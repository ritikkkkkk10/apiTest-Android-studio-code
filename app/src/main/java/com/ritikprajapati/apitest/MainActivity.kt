package com.ritikprajapati.apitest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the buttons
        val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        // Set up the Sign In button click listener
        btnSignIn.setOnClickListener {
            // Navigate to SignInActivity
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        // Set up the Sign Up button click listener
        btnSignUp.setOnClickListener {
            // Navigate to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
