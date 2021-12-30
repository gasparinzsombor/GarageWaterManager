package dataAccess

interface IO {
    suspend fun disableCleanWaterPump()
    suspend fun enableCleanWaterPump()

    suspend fun disableDirtyWaterPump()
    suspend fun enableDirtyWaterPump()

    suspend fun readSensorData(): SensorData
}