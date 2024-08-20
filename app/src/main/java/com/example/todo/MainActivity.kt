package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.screens.HomeScreen
import com.example.todo.screens.ScreenB
import com.example.todo.screens.ScreenC
import com.example.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {


                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.HOME){
                    composable(
                        route = Routes.HOME
                    ){
                        HomeScreen(todoList = emptyList(),
                            navigateToB = {
                                navController.navigate(Routes.SCREEN_B)
                            }
                            )
                            
                        }
                    composable(
                        route = Routes.SCREEN_B
                    ){
                        ScreenB(
                            navigateToHome = {
                                navController.popBackStack()
                            },
                            navigateToC = {
                                navController.navigate(Routes.SCREEN_C)
                            }

                        )
                    }
                    composable(
                        route = Routes.SCREEN_C
                    ){
                        ScreenC(navigateToHome = {
                            navController.navigate(Routes.HOME){
                                popUpTo(0)
                            }

                        },
                            navigateToB = {
                                navController.popBackStack()
                            }
                            )
                        }
                    }
                }



            }
        }
    }

