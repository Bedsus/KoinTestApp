package com.example.koinmvvmtestapp.repo

import com.google.gson.annotations.SerializedName

class NetworkClient (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?
)
