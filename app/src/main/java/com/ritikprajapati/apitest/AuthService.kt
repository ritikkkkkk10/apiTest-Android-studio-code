package com.ritikprajapati.apitest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// Define the user data for signup and signin
data class SignUpRequest(val fullName: String, val email: String, val password: String)
data class SignInRequest(val email: String, val password: String)
data class AuthResponse(val token: String, val fullName: String, val email: String)  // Add other response fields as necessary

interface AuthService {
    @POST("/api/signup")
    fun signUp(@Body request: SignUpRequest): Call<AuthResponse>

    @POST("/api/signin")
    fun signIn(@Body request: SignInRequest): Call<AuthResponse>
}