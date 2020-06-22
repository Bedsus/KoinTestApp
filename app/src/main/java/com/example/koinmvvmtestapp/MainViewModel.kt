package com.example.koinmvvmtestapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.koinmvvmtestapp.network.ResultRequest
import com.example.koinmvvmtestapp.repo.Client
import com.example.koinmvvmtestapp.repo.ClientRepository

class MainViewModel(
        repo: ClientRepository
) : ViewModel() {

    val clientList: LiveData<ResultRequest<List<Client>>> = repo.getResultClientList()
}