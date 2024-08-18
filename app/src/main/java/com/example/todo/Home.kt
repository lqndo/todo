package com.example.todo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

data class Home(
    val title : String,
    val content : String,
)

@Composable
fun HomeScreen (
    todoList: List<Home>
) {
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ){
        items(todoList) {
            todo -> com.example.todo.components.ToDoCard(title = todo.title, content = todo.content)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    val sampleTodoList = List(20) { index ->
        Home(title = "Tarea $index", content = "Descripción de la tarea $index")
    }
    HomeScreen(todoList = sampleTodoList)
}