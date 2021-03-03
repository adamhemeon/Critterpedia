package com.critterpedia.services

import com.critterpedia.models.SeaCreatureItem
import retrofit2.Call
import retrofit2.http.GET

interface SeaCreatureService {

    @GET("sea")
    fun getSeaCreatureList () : Call<List<SeaCreatureItem>>
}