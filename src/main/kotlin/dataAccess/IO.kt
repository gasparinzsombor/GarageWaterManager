package dataAccess

interface IO {
    var onDeviceDisconnect: (() -> Unit)?
    var onSensorDataReceived: ((SensorData) -> Unit)?

    val isDeviceSelected: Boolean

    fun connectDevice()

    fun selectDevice(name: String)



}