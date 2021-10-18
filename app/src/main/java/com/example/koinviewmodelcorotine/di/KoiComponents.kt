package com.example.koinviewmodelcorotine.di

import com.example.koinviewmodelcorotine.pojos.User
import com.example.koinviewmodelcorotine.viewmode.ActivityViewModel
import com.example.koinviewmodelcorotine.viewmode.ActivityViewModelCons
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    single { User("FNameFromKoin", "FromKoin") }
    viewModel { ActivityViewModel() }
    viewModel { definitionParameters ->  ActivityViewModelCons(definitionParameters.get(0),definitionParameters.get(1)) }
    // Simple Presenter Factory
    //factory { MySimplePresenter(get()) }
}