package com.critterpedia.services

import com.critterpedia.models.BugItem
import retrofit2.Call
import retrofit2.http.GET

interface BugService {

    @GET("bugs")
    fun getBugList () : Call<List<BugItem>>
}