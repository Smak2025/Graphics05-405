package ru.smak.graphics

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var s by mutableStateOf("Привет!")
    var s2 by mutableStateOf("")

    fun onUserInput(input: String) {
        s = input
    }

    fun copyText(){
        s2 = s
    }
}