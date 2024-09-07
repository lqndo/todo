package com.example.todo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.ToDo
import com.example.todo.components.ToDoCard

@Composable
fun HomeScreen(loadTodos: suspend () -> List<ToDo>) {
    var todoList = emptyList<ToDo>()

    LaunchedEffect(Unit) {
        todoList = loadTodos()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(todoList) { todo ->
            ToDoCard(title = todo.title, content = todo.content)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val sampleTodoList = List(20) { index ->
        ToDo(title = "Tarea $index", content = "Descripción de la tarea $index")
    }

    HomeScreen(
        loadTodos = { sampleTodoList }
    )
}
