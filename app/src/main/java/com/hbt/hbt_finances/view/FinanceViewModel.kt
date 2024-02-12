package com.hbt.hbt_finances.view

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hbt.hbt_finances.data.FinanceDays
import com.hbt.hbt_finances.data.RetrofitInstance
import kotlinx.coroutines.launch

class FinanceViewModel : ViewModel() {
  private val apiService = RetrofitInstance.api

  private val _days = mutableStateOf<AsyncState<List<Int>>>(AsyncState.Loading)
  val days: State<AsyncState<List<Int>>> = _days

  private val _activeDay = mutableStateOf<Int?>(null)
  val activeDay: State<Int?> = _activeDay

  fun getDays() {
    viewModelScope.launch {
      try {
        val response = apiService.getFinancesDays()

        val body = response.body()

        if (body != null) {
          _days.value = AsyncState.Success(body.days)
          _activeDay.value = body.todayInMonth
        } else {
          _days.value = AsyncState.Failure
        }
      } catch(err: Exception) {
        _days.value = AsyncState.Failure
      }
    }
  }

  fun setActiveDay(day: Int) {
    _activeDay.value = day
  }
}