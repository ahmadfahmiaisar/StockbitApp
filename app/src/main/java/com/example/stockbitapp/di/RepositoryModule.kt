package com.example.stockbitapp.di

import com.example.stockbitapp.data.repository.CustomerRepositoryImpl
import com.example.stockbitapp.domain.repository.CustomerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun bindCustomerRepository(repository: CustomerRepositoryImpl): CustomerRepository
}