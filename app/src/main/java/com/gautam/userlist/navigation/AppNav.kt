package com.gautam.userlist.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gautam.userlist.userInterface.viewModel.UserViewModel
import com.gautam.userlist.userInterface.screen.DetailScreen
import com.gautam.userlist.userInterface.screen.HomeScreen

@Composable
fun AppNav(){
    val navController = rememberNavController()
    val viewModel: UserViewModel = viewModel()
    NavHost(navController,"home"){
        composable("home"){ HomeScreen(viewModel,navController) }

        composable("detail/{id}",
                    arguments = listOf(
                        navArgument("id"){
                            type = NavType.IntType
                        }
                    )) { backStackEntry->
            val id = backStackEntry.arguments?.getInt("id")!!
            DetailScreen(id,viewModel)
        }
    }

}

