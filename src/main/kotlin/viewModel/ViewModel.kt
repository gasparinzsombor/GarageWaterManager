package viewModel

import model.Model

class ViewModel(model: Model) {
    val appState = model.state
}