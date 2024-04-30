package com.aos.eip.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiObject {
    private const val BASE_URL = "http://ec2-3-34-139-147.ap-northeast-2.compute.amazonaws.com:8080/"
    private val client = OkHttpClient.Builder()
        .build()
    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private val getRetrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            // gson을 인자로 넣어서 만들어야 한다.
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    public val getRetrofitService: RetrofitService by lazy {
        getRetrofit.create(RetrofitService::class.java)
    }
}