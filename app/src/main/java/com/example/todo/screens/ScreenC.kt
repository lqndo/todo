package com.example.todo.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.todo.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ScreenC(
    navigateToHome: () -> Unit,
    navigateToB: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .border(width = 4.dp, color = Color.Gray, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "This text is written",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )


                Row(
                    Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                        Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_cancel),
                        contentDescription = "Back"
                    )

                    Icon(
                        modifier = Modifier.size(50.dp),
                        painter = painterResource(id = R.drawable.ic_ok),
                        contentDescription = "Delete"
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewScreenC(){
    ScreenC(navigateToHome = {}, navigateToB = {})
}

