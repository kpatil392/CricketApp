package com.cricket.test.api

import com.cricket.test.model.CricketResp
import com.example.roomwithretrofit.Model.Post
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


   /* @GET("posts")
    suspend fun getAllPost():List<Post>*/

  /*  @GET("/nzin01312019187360.json")
    suspend fun getMatchDetails():Response<CricketResp>

    @GET("/nzin01312019187360.json")
    suspend fun getMatchDetailstr():Response<String>*/

    @GET("/nzin01312019187360.json")
    suspend fun getMatchDetailBody():Response<ResponseBody>

}