package com.example.todo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo.ToDo
import com.example.todo.components.ToDoCard
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment


@Composable
fun HomeScreen (
    todoList: List<ToDo>,
    navigateToB:()-> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = navigateToB) {
            Text(text = "Go to B")
        }


        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(todoList) { todo ->
                ToDoCard(title = todo.title, content = todo.content)
            }
        }
    }
}

@Composable
@Preview
fun PreviewHome(){
    HomeScreen(todoList = emptyList(), navigateToB = {})
}