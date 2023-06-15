package com.cricket.test.repository

import com.cricket.test.api.ApiServiceImpl
import com.cricket.test.dao.PostDao

class PostRepo(private val dao: PostDao,private val apiServiceImpl: ApiServiceImpl) {

}