package com.example.feature

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    viewModel { SecondViewModel(get(), get()) }
    single { Token("123") }
}