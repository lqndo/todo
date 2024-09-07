package com.example.todo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.Routes
import com.example.todo.ToDo
import com.example.todo.components.ToDoCard
import com.example.todo.components.TopAppBar

@Composable
fun HomeScreen(todoList: List<ToDo>, navigateToNote: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                route = Routes.HOME,
                navigateToHome = {},
                navigateToNote = navigateToNote
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(todoList) { todo ->
                ToDoCard(title = todo.title, content = todo.content)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val sampleTodoList = List(20) { index ->
        ToDo(title = "Tarea $index", content = "Descripción de la tarea $index")
    }
    HomeScreen(todoList = sampleTodoList, navigateToNote = {})
}
