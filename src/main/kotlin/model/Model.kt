package model

import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import view.Lce


class Model {
    var state = mutableStateOf<Lce<AppState>>(Lce.Loading)

    init {
        GlobalScope.launch {
            delay(5000)
            state.value = Lce.Content(AppState(WaterLevel.Mid, true, true))
            delay(5000)
            state.value = Lce.Content(AppState(WaterLevel.High, false, true))
        }
    }
}