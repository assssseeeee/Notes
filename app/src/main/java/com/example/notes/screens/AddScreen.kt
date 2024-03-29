package com.example.notes.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.model.Note
import com.example.notes.navigation.NavRoute
import com.example.notes.ui.MainViewModel
import com.example.notes.ui.MainViewModelFactory
import com.example.notes.ui.theme.NotesTheme
import com.example.notes.utils.Constants
import com.example.notes.utils.Constants.Keys.ADD_NEW_NOTE
import com.example.notes.utils.Constants.Keys.ADD_NOTE
import com.example.notes.utils.Constants.Keys.NOTE_SUBTITLE
import com.example.notes.utils.Constants.Keys.NOTE_TITLE


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = ADD_NEW_NOTE,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                },
                label = { Text(text = NOTE_TITLE) },
                isError = title.isEmpty()
            )
            OutlinedTextField(
                value = subtitle,
                onValueChange = {
                    subtitle = it
                    isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                },
                label = { Text(text = NOTE_SUBTITLE) },
                isError = subtitle.isEmpty()
            )
            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addNote(note = Note(title = title, subtitle = subtitle)) {
                        navController.navigate(NavRoute.Main.route)
                    }
                }
            ) {
                Text(text = ADD_NOTE)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevAddScreen() {
    NotesTheme {
        val context = LocalContext.current
        val viewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        NoteScreen(
            navController = rememberNavController(),
            viewModel = viewModel,
            noteId = "1"
        )
    }
}