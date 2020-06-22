package com.example.feature

import retrofit2.http.GET

interface TokenService {

    @GET("clients")
    suspend fun getToken(): Token
}