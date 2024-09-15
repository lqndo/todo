package com.example.todo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.Todo
import com.example.todo.ui.theme.TodoTheme

@Composable
fun TodoScreen(
    id: Int?,
    title: String,
    content: String,
    updateTitle: (String) -> Unit,
    updateContent: (String) -> Unit,
    loadTodo: (Int) -> Unit
) {
    LaunchedEffect(Unit) {
        id?.let {
            loadTodo(id)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(15.dp)
    ) {
        OutlinedTextField(
            value = title,
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth(),
            onValueChange = updateTitle,
            label = {
                Text(
                    text = "Title",
                    color = Color.White
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = content,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            onValueChange = updateContent,
            label = {
                Text(
                    text = "Content",
                    color = Color.White
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTodoScreen() {
    val todo = Todo(title = "title", content = "content")

    TodoTheme {
        TodoScreen(
            id = null,
            title = todo.title,
            content = todo.content,
            updateTitle = {},
            updateContent = {},
            loadTodo = {}
        )
    }
}
