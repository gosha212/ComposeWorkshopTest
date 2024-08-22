package com.wix.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StateExample() {
    val counterState = rememberSaveable { mutableIntStateOf(0) }

    val (value, set) = rememberSaveable {
        mutableIntStateOf(0)
    }

    Column {
        Text(text = "Counter: ${counterState.intValue}")
        Button(onClick = { counterState.intValue++ }) {
            Text(text = "Increment")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun StateExamplePreview() {
    StateExample()
}