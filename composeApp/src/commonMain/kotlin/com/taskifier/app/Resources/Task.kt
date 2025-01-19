package resources;

import io.realm.kotlin.types.annotations.PrimaryKey

//import org.mongodb.kbson.ObjectId;


open class Task(data:Map<String,Any>):Chore(data){
    @PrimaryKey
    var id=data["id"] as String;
    var name=data["name"] as String;
    var chores=(data["chores"] as? List<Map<String,Any>> ?: listOf()).map { Chore(it) };
}

open class Chore(data:Map<String,Any>){
    var description=data["description"] as String;
    open var done=data["done"] as? Boolean ?: false;

    constructor(description:String):this(mapOf(
        "description" to description
    ));
}