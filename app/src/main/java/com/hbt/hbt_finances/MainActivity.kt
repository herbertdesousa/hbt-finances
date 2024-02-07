package com.hbt.hbt_finances

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hbt.hbt_finances.ui.theme.HBTFinancesTheme
import com.hbt.hbt_finances.view.FinanceViewModel
import com.hbt.hbt_finances.view.Home

class MainActivity : ComponentActivity() {

  private val financeViewModel: FinanceViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HBTFinancesTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Home(financeViewModel)
        }
      }
    }
  }
}
