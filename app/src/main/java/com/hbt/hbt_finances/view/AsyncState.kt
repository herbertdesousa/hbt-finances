package com.hbt.hbt_finances.view

sealed class AsyncState<out T> {
  object Loading : AsyncState<Nothing>()
  data class Success<T>(val data: T) : AsyncState<T>()
  object Failure : AsyncState<Nothing>()
}