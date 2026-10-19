package ru.smak.graphics

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            modifier = Modifier.fillMaxSize().padding(16.dp),
            viewModel::onUserInput,
            viewModel::copyText
        )
    }
}

@Composable
fun UserInputPanel(
    userInput: String,
    userTextCopy: String,
    modifier: Modifier = Modifier,
    onUserInput: (String) -> Unit = {},
    onTextCopy: () -> Unit = {},
){
    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = userInput,
            onValueChange = { it ->
                onUserInput(it)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
            )
        )
        Button(onClick = {
            onTextCopy()
        }){
            Text("Нажать нежно!")
        }
        Text(
            text = userTextCopy,
            modifier = Modifier.fillMaxWidth(),
            color = if (userTextCopy.toIntOrNull() == null) Color.Red else Color.Blue
        )
    }
}