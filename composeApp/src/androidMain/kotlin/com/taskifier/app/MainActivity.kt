package com.taskifier.app

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


class MainActivity:ComponentActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        val androidTransparent=android.graphics.Color.TRANSPARENT;
        enableEdgeToEdge(
            statusBarStyle=SystemBarStyle.dark(androidTransparent),
            navigationBarStyle=SystemBarStyle.dark(androidTransparent),
        );
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(window,true);
        setContent {
            StatusBar(Theme.backgroundColor);
            App();
        }
    }
}

@Composable
fun StatusBar(backgroundColor:Color){
    val view=LocalView.current;
    if(!view.isInEditMode){
        LaunchedEffect(Unit){
            val window=(view.context as Activity).window;
            window.statusBarColor=toAndroidColor(backgroundColor);
            //WindowCompat.getInsetsController(window,view).isAppearanceLightStatusBars
        }
    }
}

fun toAndroidColor(color:Color):Int {
    return android.graphics.Color.argb(
        (color.alpha*255).toInt(),
        (color.red*255).toInt(),
        (color.green*255).toInt(),
        (color.blue*255).toInt(),
    )
}

/*@Preview @Composable
fun AppAndroidPreview(){
    App()
}*/
