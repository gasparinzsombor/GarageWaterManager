package view

import androidx.compose.runtime.*
import model.AppState
import viewModel.ViewModel

@Composable
fun MainUi(viewModel: ViewModel) {
    val state = viewModel.appState

    when(state.value) {
        is Lce.Loading -> LoadingUI()
        is Lce.Content -> ContentUI(state as MutableState<Lce.Content<AppState>>)
        is Lce.Error -> ErrorUI()
    }
}