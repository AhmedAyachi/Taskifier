package com.taskifier.app;

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.homescreen.HomeScreen


@Composable
@Preview
fun App(){
    MaterialTheme{
        Navigator(screen=HomeScreen()){
            SlideTransition(it);
        };
    }
}
