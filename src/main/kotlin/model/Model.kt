package model

import androidx.compose.runtime.mutableStateOf
import dataAccess.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import view.Lce


class Model(private val io: IO) {
    var state = mutableStateOf<Lce<AppState>>(Lce.Loading)

    init {

        GlobalScope.launch {
            delay(5000)
            state.value = Lce.Content(AppState(WaterLevel.Mid, true, true))
            delay(5000)
            state.value = Lce.Content(AppState(WaterLevel.High, false, true))
        }
    }

    init {
        try {
            io.connectDevice()
        } catch (e: Exception) {
            e.printStackTrace()
            state.value = Lce.Error(e)
        }
    }


}