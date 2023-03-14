package com.example.notes

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notes.navigation.NotesNavHost
import com.example.notes.ui.MainViewModel
import com.example.notes.ui.MainViewModelFactory
import com.example.notes.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                val context = LocalContext.current
                val viewModel: MainViewModel =
                    viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "NotesApp")
                            },
                            backgroundColor = Color.Blue,
                            contentColor = Color.White,
                            elevation = 12.dp
                        )
                    },
                    content = { padding ->
                        Surface(
                            modifier = Modifier.padding(padding),
                            color = MaterialTheme.colors.background
                        ) {
                            NotesNavHost(viewModel)
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesTheme {
    }
}