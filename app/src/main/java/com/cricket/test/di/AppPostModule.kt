package com.cricket.test.di

import com.cricket.test.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppPostModule {
    @Provides
    fun provideBaseUrl()=""

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASEURL:String):ApiService=Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)

}