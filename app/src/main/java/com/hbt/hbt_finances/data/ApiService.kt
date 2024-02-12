package com.hbt.hbt_finances.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
  @GET("finances/days")
  suspend fun getFinancesDays(): Response<FinanceDays>
}