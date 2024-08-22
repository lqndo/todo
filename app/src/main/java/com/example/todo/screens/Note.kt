package com.example.todo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                .background(Color(0xFF1D1C22))
                .padding(15.dp)
        ) {
            OutlinedTextField(
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
                        color = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(Color.White)
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

                OutlinedTextField(
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
                            color = Color.White
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(Color.White)
                )
            }
        }



@Preview(showSystemUi = true)
@Composable
fun PreviewNoteScreen() {
    NoteScreen(title = "Title", content = "Content")
}