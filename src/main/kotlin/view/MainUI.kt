package view

import androidx.compose.runtime.*
import model.AppState
import model.MultiplePortsException
import viewModel.ViewModel

@Composable
fun MainUi(viewModel: ViewModel) {
    val state = viewModel.appState

    @Suppress("UNCHECKED_CAST")
    when(val actualState = state.value) {
        is Lce.Loading -> LoadingUI()
        is Lce.Content -> ContentUI(state as MutableState<Lce.Content<AppState>>)
        is Lce.Error -> when (actualState.error) {
            is MultiplePortsException -> DeviceSelectorUI(actualState.error.ports, viewModel)
            else -> ErrorUI(actualState.error)
        }
    }
}