package com.example.btt2screen.service

import com.example.btt2screen.home.Property
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://ccku8m75ys.api.quickmocker.com111"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

interface ApiService{

    @GET("/furnitute")
    fun getAllData(): Call<List<Property>>
    @GET("/furniture/chair")
    fun getChairData(): Call<List<Property>>
    @GET("/furniture/sofa")
    fun getsofaData(): Call<List<Property>>
    @GET("/furniture/cabinet")
    fun getwardrobeData(): Call<List<Property>>
    @GET("/furniture/plantpot")
    fun getplantpotData(): Call<List<Property>>
}
object Api {
    val retrofitService: ApiService by lazy{retrofit.create(ApiService::class.java)}
}