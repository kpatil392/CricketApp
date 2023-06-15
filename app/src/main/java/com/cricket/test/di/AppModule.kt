package com.cricket.test.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cricket.test.api.ApiService
import com.cricket.test.api.ApiServiceImpl
import com.cricket.test.dao.PostDao
import com.cricket.test.database.PostDatabase
import com.cricket.test.repository.PostRepo
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideBaseUrl() ="https://demo.sportz.io/"

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context:Context):PostDatabase=
       Room.databaseBuilder(context,PostDatabase::class.java,"ndb").build()

    @Provides
    fun provideDao(db:PostDatabase):PostDao=db.getPostDao()

    @Provides
    fun providesPostRepo(dao: PostDao,apiService: ApiServiceImpl):PostRepo
    {
       return PostRepo(dao,apiService)
    }
}