package resources;


fun String.capitalize(limit:Int=-1):String {
    return this.split(" ").joinToString(" ", limit=limit){
        it.replaceFirstChar {char->char.uppercaseChar()};
    };
}
