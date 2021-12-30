package model

class MultiplePortsException(val ports: List<String>) : Exception() {
}