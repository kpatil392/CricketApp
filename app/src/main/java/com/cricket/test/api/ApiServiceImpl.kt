package com.cricket.test.api

class ApiServiceImpl(val apiService: ApiService) {
suspend fun getMatchDetai()=apiService.getMatchDetails()
    suspend fun getPost()=apiService.getAllPost()
}