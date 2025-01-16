package com.taskifier.app;

import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.navigator.Navigator;
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview;
import screens.homescreen.HomeScreen;


@Composable
@Preview
@OptIn(InternalVoyagerApi::class)
fun App(){
    MaterialTheme {
        Navigator(screen=HomeScreen()){
            SlideTransition(it);
        };
    }
}