package com.wix.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wix.myapplication.ui.theme.ComposeWorkshopTestTheme

private data class User(val name: String, val description: String)

@Composable
fun Layouts() {

    val users = (1..100).map { User("User $it", "Description $it") }

    LazyColumn {
        item {
            Header()
        }

        items(users) { user ->
            Item(user.name, user.description)
        }
    }
}

@Composable
private fun Header() {
    Text(
        text = "Header",
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Item(name: String, description: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(end = 16.dp, bottom = 16.dp, top = 16.dp)
                .size(24.dp),
            imageVector = Icons.Rounded.Face,
            contentDescription = ""
        )

        Column {
            Text(text = name, style = MaterialTheme.typography.bodyLarge )
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ItemPreview() {
    ComposeWorkshopTestTheme {
        Item("Item 1", "Description 1")
    }
}

@Preview(showBackground = true)
@Composable
private fun LayoutsPreview() {
    ComposeWorkshopTestTheme {
        Layouts()
    }
}