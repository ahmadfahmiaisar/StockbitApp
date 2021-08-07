package com.example.stockbitapp.di

import com.example.stockbitapp.data.service.CustomerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideCustomerService(retrofit: Retrofit): CustomerService =
        retrofit.create(CustomerService::class.java)
}