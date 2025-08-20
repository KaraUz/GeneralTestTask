package com.example.generaltesttask

import com.example.generaltesttask.attractionsearch.data.AttractionRepository
import com.example.generaltesttask.attractionsearch.data.AttractionRepositoryImpl
import com.example.generaltesttask.attractionsearch.data.network.AttractionService
import com.example.generaltesttask.attractionsearch.data.network.AttractionServiceImpl
import com.example.generaltesttask.attractionsearch.domain.SearchAttractionsUseCase
import com.example.generaltesttask.attractionsearch.domain.SearchAttractionsUseCaseImpl
import com.example.generaltesttask.attractionsearch.ui.search.AttractionSearchViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val appModule = module {
    factoryOf(::AttractionServiceImpl) bind AttractionService::class
    singleOf(::AttractionRepositoryImpl) bind AttractionRepository::class
    factoryOf(::SearchAttractionsUseCaseImpl) bind SearchAttractionsUseCase::class
    viewModelOf(::AttractionSearchViewModel)
}
