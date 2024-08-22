package com.wix.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow


class MyViewModel : ViewModel() {

    val text = MutableStateFlow("")

    fun setText(newText: String) {
        text.value = newText
    }
}

@Composable
fun ScreenWithViewModel(viewModel: MyViewModel = viewModel()) {
    val text = viewModel.text.collectAsState()
    ScreenWithViewModel(text.value, viewModel::setText)
}

@Composable
fun ScreenWithViewModel(text: String, onTextUpdate: (String) -> Unit) {
    Column {
        Text(text = text)
        TextField(value = text, onValueChange = onTextUpdate)
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenWithViewModelPreview() {
    ScreenWithViewModel("Hello, World!") {}
}
