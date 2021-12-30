package view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import model.Model
import viewModel.ViewModel

@Composable
fun DeviceSelectorUI(devices: List<String>, viewModel: ViewModel) {
    Column {
        Text(text = "Több eszköz is rendelkezésre áll. Válassz:", fontWeight = FontWeight.Bold)
        for(device in devices) {
            Text(text = device, modifier = Modifier.clickable { viewModel.selectDevice(device) })
        }
    }
}