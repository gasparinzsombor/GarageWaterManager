package model

data class AppState(val waterLevel: WaterLevel, val isCleanWaterPumpAvailable: Boolean, val isDirtyWaterPumpAvailable: Boolean)