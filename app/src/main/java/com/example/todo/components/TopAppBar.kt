package com.example.todo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import com.example.todo.R
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.todo.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    route: String,
    navigateToHome:()-> Unit,
    navigateToC:()-> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "ToDo",
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            val openDialog = remember { mutableStateOf(false)  }
            if (route == Routes.SCREEN_B) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_leftarrow),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(onClick = {
                            openDialog.value = true
                        })
                        .size(35.dp)
                )
                if (openDialog.value) {
                    AlertDialog(onDismissRequest = {
                        openDialog.value = false
                    },
                        title = {
                            Text(text = "Do you want to leave without saving?")
                        }
                        ,
                        confirmButton = { 
                            Button(onClick = navigateToHome) {
                                Text(text = "Confirm")
                            }

                        },
                        dismissButton = {
                            TextButton(onClick = {openDialog.value = false}) {
                                Text(text = "Cancel")
                            }
                        }
                        )

                }
            }
        },
        actions = {
            if (route == Routes.HOME){
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
            )
                }
            else if (route == Routes.SCREEN_B ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_ok),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(onClick = navigateToHome)
                        .size(35.dp))

            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTopAppBar() {
    TopAppBar(route = Routes.SCREEN_B,{}){}
}