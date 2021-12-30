package dataAccess

interface IO {
    var onDeviceDisconnect: (() -> Unit)?

    fun connectDevice()

    suspend fun disableCleanWaterPump()
    suspend fun enableCleanWaterPump()

    suspend fun disableDirtyWaterPump()
    suspend fun enableDirtyWaterPump()

    suspend fun readSensorData(): SensorData


}