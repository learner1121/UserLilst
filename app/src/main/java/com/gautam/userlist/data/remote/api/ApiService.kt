package com.gautam.userlist.data.remote.api

import com.gautam.userlist.data.remote.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun fetchData(): List<User>
}