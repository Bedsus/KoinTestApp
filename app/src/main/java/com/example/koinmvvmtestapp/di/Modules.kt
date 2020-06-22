package com.example.koinmvvmtestapp.di

import com.example.koinmvvmtestapp.MainViewModel
import com.example.koinmvvmtestapp.repo.ClientLocalDataSource
import com.example.koinmvvmtestapp.repo.ClientRemoteDataSource
import com.example.koinmvvmtestapp.repo.ClientRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
    single { ClientRepository(get(), get()) }
    single { ClientRemoteDataSource(get()) }
    single { ClientLocalDataSource() }
}

