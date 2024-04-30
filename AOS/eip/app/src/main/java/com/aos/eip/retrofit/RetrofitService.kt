package com.aos.eip.retrofit

import com.aos.eip.dto.Workbook
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/workbook")
    fun getWorkBookList(

    ): Call<List<Workbook>>
}