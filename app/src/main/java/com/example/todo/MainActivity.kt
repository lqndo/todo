package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.components.TopAppBar
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
                NavHost(navController = navController, startDestination = "home" ){
                    composable(
                        route = "home",
                        exitTransition = {
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left ,
                                tween(1000)
                            )
                        }
                    ){
                        HomeScreen(todoList = emptyList(),
                            navigateToB = {
                                navController.navigate("screen_b")
                            }
                            )
                            
                        }
                    composable(
                        route = "screen_b"
                    ){
                        ScreenB(
                            navigateToHome = {
                                navController.popBackStack()
//                                NavController.navigate(route = "home")
                            },
                            navigateToC = {
                                navController.navigate("screen_c")
                            }

                        )
                    }
                    composable(
                        route = "screen_c"
                    ){
                        ScreenC(navigateToHome = {
                            navController.navigate("home"){
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

