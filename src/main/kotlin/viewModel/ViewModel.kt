package viewModel

import model.Model

class ViewModel(private val model: Model) {
    val appState = model.state
}