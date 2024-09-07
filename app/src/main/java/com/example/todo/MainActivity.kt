package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.components.TopAppBar
import com.example.todo.database.TodoDatabase
import com.example.todo.screens.HomeScreen
import com.example.todo.screens.NoteScreen
import com.example.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this
        val dao = TodoDatabase.getDatabase(context).dao()
        val repository = TodoRepository(dao)

        setContent {
            TodoTheme {
                val navController = rememberNavController()
                var currentRoute by remember { mutableStateOf(Routes.HOME) }

                navController.addOnDestinationChangedListener { _, destination, _ ->
                    destination.route?.let { route ->
                        currentRoute = route
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            route = currentRoute,
                            navigateToHome = { navController.popBackStack() },
                            navigateToNote = { navController.navigate(Routes.NOTE) }
                        )
                    }
                ) { paddings ->
                    NavHost(
                        modifier = Modifier.padding(paddings),
                        navController = navController,
                        startDestination = Routes.HOME
                    ) {
                        composable(
                            route = Routes.HOME
                        ) {
                            HomeScreen(
                                loadTodos = repository::loadTodos
                            )
                        }

                        composable(
                            route = Routes.NOTE
                        ) {
                            NoteScreen(
                                title = "Title",
                                content = "Content"
                            )
                        }
                    }
                }
            }
        }
    }
}
