package com.example.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.screens.AddScreen
import com.example.notes.screens.MainScreen
import com.example.notes.screens.NoteScreen
import com.example.notes.screens.StartScreen
import com.example.notes.ui.MainViewModel
import com.example.notes.utils.Constants
import com.example.notes.utils.Constants.Screens.ADD_SCREEN
import com.example.notes.utils.Constants.Screens.MAIN_SCREEN
import com.example.notes.utils.Constants.Screens.NOTE_SCREEN
import com.example.notes.utils.Constants.Screens.START_SCREEN


sealed class NavRoute(val route: String) {
    object Start : NavRoute(START_SCREEN)
    object Main : NavRoute(MAIN_SCREEN)
    object Add : NavRoute(ADD_SCREEN)
    object Note : NavRoute(NOTE_SCREEN)
}

@Composable
fun NotesNavHost(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) {
            StartScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(NavRoute.Add.route) {
            AddScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            NoteScreen(
                navController = navController,
                viewModel = viewModel,
                noteId = backStackEntry.arguments?.getString(Constants.Keys.ID)
            )
        }
        composable(NavRoute.Main.route) {
            MainScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}