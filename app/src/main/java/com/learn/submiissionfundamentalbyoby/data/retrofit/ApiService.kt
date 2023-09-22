package com.learn.submiissionfundamentalbyoby.data.retrofit

import com.learn.submiissionfundamentalbyoby.data.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    @Headers("Authorization: token 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")
    fun getUserOby(
        @Query("q")  query: String
    ) : Call<UserResponse>
}