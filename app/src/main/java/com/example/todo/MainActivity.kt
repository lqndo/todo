package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.components.TopAppBar
import com.example.todo.screens.HomeScreen
import com.example.todo.screens.NoteScreen
import com.example.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TodoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            route = Routes.HOME,
                            navigateToHome = {},
                            navigateToNote = {}
                        )
                    }
                ) { paddings ->
                    val navController = rememberNavController()

                    NavHost(
                        modifier = Modifier.padding(paddings),
                        navController = navController,
                        startDestination = Routes.HOME
                    ) {
                        composable(
                            route = Routes.HOME
                        ) {
                            HomeScreen(
                                todoList = emptyList(),
                                navigateToNote = {
                                    navController.navigate(Routes.NOTE)
                                }
                            )
                        }

                        composable(
                            route = Routes.NOTE
                        ) {
                            NoteScreen(
                                title = "Title",
                                content = "Content",
                                navigateToHome = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
