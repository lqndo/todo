package com.example.todo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.todo.Routes
import com.example.todo.components.TopAppBar

@Composable
fun NoteScreen(title: String, content: String, navigateToHome: () -> Unit) {
    var titleText by remember { mutableStateOf(TextFieldValue("")) }
    var contentText by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            TopAppBar(
                route = Routes.NOTE,
                navigateToHome = navigateToHome,
                navigateToNote = {}
            )
        }
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color(0xFF1D1C22))
                .padding(15.dp)
        ) {
            OutlinedTextField(
                value = titleText,
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
                onValueChange = {
                    titleText = it
                },
                label = {
                    Text(
                        text = "Title",
                        color = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(Color.White)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = contentText,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                onValueChange = {
                    contentText = it
                },
                label = {
                    Text(
                        text = "Content",
                        color = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(Color.White)
            )
        }
    }
}

@Composable
fun PreviewNoteScreen() {
    NoteScreen(title = "Title", content = "Content", navigateToHome = {})
}
