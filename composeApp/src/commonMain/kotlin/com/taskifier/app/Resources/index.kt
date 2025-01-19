package resources;


fun randomId(length:Int=15):String {
    val characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    return (1..length).map { characters.random() }.joinToString("");
}

fun String.capitalize(limit:Int=-1):String {
    return this.split(" ").joinToString(" ", limit=limit){
        it.replaceFirstChar {char->char.uppercaseChar()};
    };
}
