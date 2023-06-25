package com.cricket.test.repository

import com.cricket.test.api.ApiService
import javax.inject.Inject

class MatchRepository @Inject constructor(private val api: ApiService) {
 /*   suspend fun getMatchDetails() = api.getMatchDetails()
    suspend fun getMatchDetailStr() = api.getMatchDetailstr()*/

    suspend fun getMatchDetailBody() = api.getMatchDetailBody()
}