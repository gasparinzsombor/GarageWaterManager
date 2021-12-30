package view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import model.AppState
import model.WaterLevel
import viewModel.ViewModel


@Composable
fun ContentUI(appState: MutableState<Lce.Content<AppState>>) {

        val state = appState.value.data

        Row {
                Text("Szennyvíz hordó szintje: ")
                when (state.waterLevel) {
                        WaterLevel.Mid -> Text("Normál", color = Color.Green)
                        WaterLevel.High -> Text("Magas", color = Color.Red)
                        WaterLevel.Low -> Text("Alacsony", color = Color.Red)
                }
        }


        Row {
                Text("Tisztavizes szivattyú engedélyezve: ")
                if(state.isCleanWaterPumpAvailable) {
                        Text("✓", color = Color.Green)
                }
                else {
                        Text("✘", color = Color.Red)
                }
        }

        Row {
                Text("Szennyvíz szivattyú engedélyezve: ")
                if(state.isDirtyWaterPumpAvailable) {
                        Text("✓", color = Color.Green)
                }
                else {
                        Text("✘", color = Color.Red)
                }
        }

}