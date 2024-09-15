package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todo.components.TopAppBar
import com.example.todo.database.TodoDatabase
import com.example.todo.screens.HomeScreen
import com.example.todo.screens.TodoScreen
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.viewmodels.HomeViewModel
import com.example.todo.viewmodels.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this
        val dao = TodoDatabase.getDatabase(context).dao()
        val repository = TodoRepository(dao)

        setContent {
            TodoTheme {
                MainScreen(repository)
            }
        }
    }
}

@Composable
fun MainScreen(repository: TodoRepository) {
    val navController = rememberNavController()
    var currentRoute by remember { mutableStateOf(Routes.HOME) }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        destination.route?.let { route ->
            currentRoute = route
        }
    }

    val homeViewModel = HomeViewModel(repository)
    val todoViewModel = TodoViewModel(repository)
    val todos by homeViewModel.todos.collectAsState()
    val title by todoViewModel.title.collectAsState()
    val content by todoViewModel.content.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                route = currentRoute,
                navigateToHome = { navController.popBackStack() },
                navigateToTodo = { navController.navigate(Routes.TODO) }
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
                    todos = todos,
                    loadTodos = homeViewModel::loadTodos
                )
            }

            composable(
                route = Routes.TODO,
                arguments = listOf(
                    navArgument("id") {
                        nullable = true
                        defaultValue = null
                    }
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toInt()

                TodoScreen(
                    id = id,
                    title = title,
                    content = content,
                    updateTitle = todoViewModel::updateTitle,
                    updateContent = todoViewModel::updateContent,
                    loadTodo = todoViewModel::loadTodo,
                    saveTodo = todoViewModel::saveTodo
                )
            }
        }
    }
}
