package view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorUI(throwable: Throwable) {
    Column {
        Text("Hiba!")
        Text(throwable.message ?: "Ismeretlen hiba")
    }
}