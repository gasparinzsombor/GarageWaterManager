package viewModel

import model.Model

class ViewModel(private val model: Model) {
    val appState = model.state

    fun selectDevice(name: String) {
        model.selectDevice(name)
    }
}