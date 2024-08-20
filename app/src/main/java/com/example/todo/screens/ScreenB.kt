package com.example.todo.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenB(
    navigateToHome:()-> Unit,
    navigateToC :()-> Unit
    ) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Screen B") })
        })
    {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(onClick = navigateToHome) {
                Text(text = "Go to Home")
            }
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = navigateToC) {
                Text(text = "Navigate to C")
                
            }
        }
    }
}
@Preview
@Composable
fun ScreenB_Prev()
{
//    ScreenB()
}


