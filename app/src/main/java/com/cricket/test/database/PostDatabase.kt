package com.cricket.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cricket.test.dao.PostDao
import com.example.roomwithretrofit.Model.Post

@Database(entities =[Post::class], version = 1, exportSchema = false)
abstract class PostDatabase():RoomDatabase() {
    abstract fun getPostDao():PostDao
}