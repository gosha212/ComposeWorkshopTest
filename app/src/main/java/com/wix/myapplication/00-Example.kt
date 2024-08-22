package com.wix.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Example() {
    ListExample()
}

@Composable
fun ListExample() {
    val names = (1..100).map { it.toString() }
    LazyColumn {
        item {
            Greeting(name = "Headline")
        }

        items(names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun ColumnExample() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Greeting(name = "Android")
        Greeting(name = "there")
        Greeting(name = "Compose!")
    }
}

@Composable
fun Greeting(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.Blue, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = "Hello $name!",
            color = Color.White,
            modifier = Modifier.alignByBaseline(),
        )
        Text(
            text = "Goodbye $name!",
            color = Color.Gray,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 16.dp)
                .alignByBaseline(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android")
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Example()
}