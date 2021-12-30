// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dataAccess.MockIO
import model.Model
import view.App
import viewModel.ViewModel


fun main() {
    val io = MockIO()
    val model = Model(io)
    val viewModel = ViewModel(model)

    application {
        Window(onCloseRequest = ::exitApplication) {
            App(viewModel)
        }
    }
}
