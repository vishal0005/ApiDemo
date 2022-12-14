package com.api.demo.repository

import com.api.demo.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiInterface {

    @GET("users")
    suspend fun getUser(): Response<UserModel>

}