package com.example.api.services

import com.example.api.models.ArticlesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ConduitAPI {
    @GET("articles")
    suspend fun getArticles(
            @Query("author") author : String? = null,
            @Query("favourited") favourited : String? = null,
            @Query("tag") tags: List<String>? = null
    ) : Response<ArticlesResponse>
}