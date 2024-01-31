package com.hbt.hbt_finances.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home() {
  var activeIndex by remember { mutableStateOf(0) }

  LazyRow(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 48.dp),
    contentPadding =  PaddingValues(horizontal = 24.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    items(
      count = 31,
      key = { it }
    ) {
      val isSelected = activeIndex == it

      Button(
        onClick = { activeIndex = it },
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
          text = "$it",
          fontSize = 16.sp,
          softWrap = true,
          color = if (isSelected) colorScheme.onPrimary else colorScheme.onBackground
        )
      }
    }
  }
}