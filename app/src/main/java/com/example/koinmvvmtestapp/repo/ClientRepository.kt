package com.example.koinmvvmtestapp.repo

import androidx.lifecycle.liveData
import com.example.koinmvvmtestapp.network.ClientService
import com.example.koinmvvmtestapp.network.ResultRequest
import retrofit2.Retrofit

class ClientRepository(
    private val localDataSource: ClientLocalDataSource,
    private val remoteDataSource: ClientRemoteDataSource
) {
    fun getResultClientList() = liveData {
        emit(ResultRequest.Loading)
        try {
            val remoteClientList = remoteDataSource.getClientList().map {
                Client(it.id ?: 0, it.name ?: "")
            }
            emit(ResultRequest.Success(remoteClientList))
        } catch (ex: Exception) {
            try {
                val localClientList = localDataSource.getClientList()
                emit(ResultRequest.Success(localClientList))
            }catch (ex: Exception) {
                emit(ResultRequest.Error(ex))
            }
        }
    }
}

class ClientLocalDataSource {
    fun getClientList() = listOf(Client(1, "Sergey"), Client(2, "Stas"))
}

class ClientRemoteDataSource(
    private val retrofit: Retrofit
) {
    private val clientService = retrofit.create(ClientService::class.java)

    suspend fun getClientList() = clientService.getClientList()
}