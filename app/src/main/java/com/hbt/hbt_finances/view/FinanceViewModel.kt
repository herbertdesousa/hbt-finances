package com.hbt.hbt_finances.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hbt.hbt_finances.data.Day
import com.hbt.hbt_finances.data.RetrofitInstance
import kotlinx.coroutines.launch

class FinanceViewModel : ViewModel() {
  private val apiService = RetrofitInstance.api

  private val _days = mutableStateOf<AsyncState<List<Day>>>(AsyncState.Loading)
  val days: State<AsyncState<List<Day>>> = _days

  private val _activeDay = mutableStateOf<Day?>(null)
  val activeDay: State<Day?> = _activeDay

  fun getDays() {
    viewModelScope.launch {
      try {
        val response = apiService.getDays()

        val body = response.body()

        if (body != null) {
          _days.value = AsyncState.Success(body)
        } else {
          _days.value = AsyncState.Failure
        }
      } catch(err: Exception) {
        _days.value = AsyncState.Failure
      }
    }
  }

  fun setActiveDay(day: Day) {
    _activeDay.value = day
  }
}