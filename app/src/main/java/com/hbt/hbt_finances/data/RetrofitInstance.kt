package com.hbt.hbt_finances.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
  val api: ApiService by lazy {
    Retrofit.Builder()
      .baseUrl("https://lgnlwf49-3000.brs.devtunnels.ms/api/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(ApiService::class.java)
  }
}