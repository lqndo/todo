package com.example.todo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo.ui.theme.TodoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoCard(title: String, content: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = TodoTheme.colors.primary
        ),
        shape = RectangleShape,
        onClick = {}
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = title,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                color = TodoTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = content,
                maxLines = 2,
                fontSize = 18.sp,
                color = TodoTheme.colors.onPrimary
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCard() {
    TodoTheme(darkTheme = true) {
        ToDoCard(title = "Title", content = "Content")
    }
}
