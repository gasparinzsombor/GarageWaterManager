package view

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import model.AppState
import model.WaterLevel


@Composable
fun ContentUI(appState: MutableState<Lce.Content<AppState>>) {

        val state = appState.value.data
        val isCleanWaterPumpAvailable = state.waterLevel != WaterLevel.High
        val isDirtyWaterPumpAvailable = state.waterLevel != WaterLevel.Low

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
                if(isCleanWaterPumpAvailable) {
                        Text("✓", color = Color.Green)
                }
                else {
                        Text("✘", color = Color.Red)
                }
        }

        Row {
                Text("Szennyvíz szivattyú engedélyezve: ")
                if(isDirtyWaterPumpAvailable) {
                        Text("✓", color = Color.Green)
                }
                else {
                        Text("✘", color = Color.Red)
                }
        }

}