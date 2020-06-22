package com.example.koinmvvmtestapp.network

import com.example.koinmvvmtestapp.repo.NetworkClient
import retrofit2.http.GET

interface ClientService {

    @GET("clients")
    suspend fun getClientList(): List<NetworkClient>
}