package model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import dataAccess.IO
import dataAccess.SensorData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import view.Lce


class Model(private val io: IO) {
    var state = mutableStateOf<Lce<AppState>>(Lce.Loading)

    init {
        io.onSensorDataReceived = { onSensorDataReceived(it) }
        io.onDeviceDisconnect = { onDeviceDisconnect() }

        try {
            io.connectDevice()
        } catch (e: Exception) {
            e.printStackTrace()
            state.value = Lce.Error(e)
        }
    }

    private fun onDeviceDisconnect() {
        state.value = Lce.Error(Exception("Az eszköz lecsatlakozott."))
    }

    private fun onSensorDataReceived(data: SensorData) {
        val waterLevel = if(data.dirtyWaterTooMuch) WaterLevel.High else if(data.dirtyWaterTooLittle) WaterLevel.Low else WaterLevel.Mid
        state.value = Lce.Content(AppState(waterLevel))
    }


}