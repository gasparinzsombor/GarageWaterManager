package dataAccess

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MockIO : IO {
    override var onDeviceDisconnect: (() -> Unit)? = null
    override var onSensorDataReceived: ((SensorData) -> Unit)? = null

    override val isDeviceSelected: Boolean
        get() = onDeviceDisconnect != null

    override fun connectDevice() {
        return
    }

    init {
        GlobalScope.launch {
            while(true) {
                delay(3000)
                val tooLittle = Random.nextBoolean()
                val tooMuch = Random.nextBoolean()
                val data = SensorData(tooLittle, tooMuch)
                onSensorDataReceived?.invoke(data)
            }
        }
    }

}