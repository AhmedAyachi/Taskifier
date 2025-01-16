package com.taskifier.app;
import androidx.compose.ui.graphics.Color;


object Theme {
    val mainFont="";
    val majorFont="";
    val minorFont="";
    val mainColor=Color(238,127,23);
    val majorColor=Color(255,255,255);
    val minorColor=Color(249,249,249);
    val accentColor=Color(0,0,0);
    val textColor=Color(0,0,0);
    val backgroundColor=Color(255,255,255);
}

fun String.capitalize(limit:Int=-1):String {
    return this.split(" ").joinToString(" ", limit=limit){
        it.replaceFirstChar {char->char.uppercaseChar()};
    };
}
