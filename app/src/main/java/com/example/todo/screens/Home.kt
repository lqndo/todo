package com.example.todo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.Todo
import com.example.todo.components.ToDoCard

@Composable
fun HomeScreen(todos: List<Todo>, loadTodos: suspend () -> Unit) {
    LaunchedEffect(Unit) {
        loadTodos()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(todos) { todo ->
            ToDoCard(title = todo.title, content = todo.content)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val sampleTodoList = List(20) { index ->
        Todo(title = "Tarea $index", content = "Descripción de la tarea $index")
    }

    HomeScreen(
        todos = sampleTodoList,
        loadTodos = {}
    )
}
