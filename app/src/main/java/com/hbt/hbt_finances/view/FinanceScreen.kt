package com.hbt.hbt_finances.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home(financeViewModel: FinanceViewModel) {
  val days = financeViewModel.days.value

  LaunchedEffect(Unit) {
    financeViewModel.getDays()
  }

  when (days) {
    is AsyncState.Loading -> Text(text = "carregando")
    is AsyncState.Failure -> Text(text = "falha ao carregar")
    is AsyncState.Success -> {
      LazyRow(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 48.dp),
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        items(days.data) { day ->
          val isSelected = financeViewModel.activeDay.value?.id == day.id

          Button(
            onClick = { financeViewModel.setActiveDay(day) },
            colors = ButtonDefaults.buttonColors(
              containerColor = if (isSelected) colorScheme.primary else colorScheme.background
            ),
            modifier = Modifier
              .height(64.dp)
              .width(64.dp)
              .border(
                1.dp,
                shape = RoundedCornerShape(50),
                color = if (isSelected) colorScheme.background else colorScheme.primary,
              ),
          ) {
            Text(
              text = "${day.day}",
              fontSize = 16.sp,
              softWrap = true,
              color = if (isSelected) colorScheme.onPrimary else colorScheme.onBackground
            )
          }
        }
      }
    }
  }


}