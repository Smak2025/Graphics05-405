package ru.smak.graphics

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import graphics.shared.generated.resources.Res
import graphics.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(viewModel: MainViewModel = MainViewModel()) {
    MaterialTheme {
        UserInputPanel(
            viewModel.s,
            viewModel.s2,
            viewModel::onUserInput,
            viewModel::copyText
        )
    }
}

@Composable
fun UserInputPanel(
    userInput: String,
    userTextCopy: String,
    onUserInput: (String) -> Unit,
    onTextCopy: () -> Unit,
){
    Column {
        OutlinedTextField(value = userInput, onValueChange = {
            onUserInput(it)
        })
        Button(onClick = {
            onTextCopy()
        }){
            Text("Нажать нежно!")
        }
        Text(text = userTextCopy)
    }
}