package com.example.notes.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.navigation.NavRoute
import com.example.notes.ui.MainViewModel
import com.example.notes.ui.MainViewModelFactory
import com.example.notes.ui.theme.NotesTheme
import com.example.notes.utils.Constants.Keys.FIREBASE_DATABASE
import com.example.notes.utils.Constants.Keys.ROOM_DATABASE
import com.example.notes.utils.Constants.Keys.WHAT_WILL_WE_USE
import com.example.notes.utils.TYPE_FIREBASE
import com.example.notes.utils.TYPE_ROOM

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val viewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = WHAT_WILL_WE_USE)
            Button(
                onClick = {
                    viewModel.initDatabase(TYPE_ROOM) {
                        navController.navigate(route = NavRoute.Main.route)
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = ROOM_DATABASE)
            }
            Button(
                onClick = {
                    viewModel.initDatabase(TYPE_FIREBASE) {
                        navController.navigate(route = NavRoute.Main.route)
                    }
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = FIREBASE_DATABASE)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen() {
    NotesTheme {
        val context = LocalContext.current
        val viewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        StartScreen(navController = rememberNavController(), viewModel = viewModel)
    }
}
