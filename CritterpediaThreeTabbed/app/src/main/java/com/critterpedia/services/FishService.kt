package com.critterpedia.services

import com.critterpedia.models.FishItem
import retrofit2.Call
import retrofit2.http.GET

interface FishService {

    @GET("fish")
    fun getFishList () : Call<List<FishItem>>
}