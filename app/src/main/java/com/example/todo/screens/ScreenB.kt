package com.example.todo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.todo.Routes
import com.example.todo.components.TopAppBar


@Composable
fun ScreenB(
    navigateToHome:()-> Unit,
    navigateToC :()-> Unit
    ) {
    Scaffold(
        topBar = {
            TopAppBar(route = Routes.SCREEN_B,
                navigateToHome = navigateToHome,
                navigateToC = navigateToC)

        })
    { it ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var task by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(value = task,
                modifier = Modifier.height(70.dp),
                onValueChange = {
                    task = it
                },
                label = { Text(text = "Task") })

            Spacer(modifier = Modifier.size(10.dp))

            var body  by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(value = body,
                modifier = Modifier.weight(1f),
                onValueChange = {
                    body = it
                },
                label = { Text(text = "Task Description") })
        }
    }
}
@Preview
@Composable
fun PreviewScreenB(){
    ScreenB(navigateToHome = {}, navigateToC = {})
}


