package com.example.feature

import androidx.lifecycle.ViewModel
import retrofit2.Retrofit

class SecondViewModel(
    retrofit: Retrofit,
    val token: Token
) : ViewModel() {

    private val service = retrofit.create(TokenService::class.java)

}