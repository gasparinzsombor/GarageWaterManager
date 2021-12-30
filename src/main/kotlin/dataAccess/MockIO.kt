package dataAccess

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import model.MultiplePortsException
import kotlin.random.Random

class MockIO : IO {
    override var onDeviceDisconnect: (() -> Unit)? = null
    override var onSensorDataReceived: ((SensorData) -> Unit)? = null

    override val isDeviceSelected: Boolean
        get() = onDeviceDisconnect != null

    override fun connectDevice() {
        throw MultiplePortsException(listOf("COM1", "COM2", "COM3"))
    }

    override fun selectDevice(name: String) {

    }

    init {
        GlobalScope.launch {
            while(!isDeviceSelected) {
                delay(1000)
            }

            while(isDeviceSelected) {
                delay(3000)
                val tooLittle = Random.nextBoolean()
                val tooMuch = Random.nextBoolean()
                val data = SensorData(tooLittle, tooMuch)
                onSensorDataReceived?.invoke(data)
            }
        }
    }

}