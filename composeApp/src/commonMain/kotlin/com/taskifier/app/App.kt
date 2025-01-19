package com.taskifier.app;

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import screens.homescreen.HomeScreen


@Composable
fun App(){
    MaterialTheme {
        Navigator(screen=HomeScreen()){ navigator ->
            SlideTransition(navigator);
        };
    }
}
