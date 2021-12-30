package dataAccess

import com.fazecast.jSerialComm.SerialPort
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*class ArduinoIO : IO {

    private var port: SerialPort? = null

    override var onDeviceDisconnect: (() -> Unit)? = null


    override fun connectDevice() {
        val ports = SerialPort.getCommPorts()

        if(ports.isEmpty()) throw Exception("Az Arduino nincs csatlakoztatva")
        if(ports.size > 1) throw Exception("Az géphez több eszköz is csatlakoztatva van")

        port = ports[0]

    }

    override suspend fun disableCleanWaterPump() {
        TODO("Not yet implemented")
    }

    override suspend fun enableCleanWaterPump() {
        TODO("Not yet implemented")
    }

    override suspend fun disableDirtyWaterPump() {
        TODO("Not yet implemented")
    }

    override suspend fun enableDirtyWaterPump() {
        TODO("Not yet implemented")
    }

    override suspend fun readSensorData(): SensorData {
        TODO("Not yet implemented")
    }
}*/