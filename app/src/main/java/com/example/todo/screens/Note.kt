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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.theme.TodoTheme

@Composable
fun NoteScreen(
    title : String,
    content : String
) {
    var titleText by remember { mutableStateOf(TextFieldValue(""))}
    var contentText by remember { mutableStateOf(TextFieldValue("")) }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(15.dp)
        ) {
            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.primary,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primary
                ),
                value = titleText,
                onValueChange = {
                    titleText = it
                },
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = "Title",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.primary,
                        unfocusedContainerColor = MaterialTheme.colorScheme.primary
                    ),
                    value = contentText,
                    onValueChange = {
                        contentText = it
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    label = {
                        Text(
                            text = "Content",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                )
            }
        }



@Preview(showSystemUi = true) //, device = Devices.TABLET)
@Composable
fun PreviewNoteScreen() {
    TodoTheme(darkTheme = true) {
        NoteScreen(title = "Title", content = "Content")
    }
}
