package resources;

import io.realm.kotlin.types.annotations.PrimaryKey

//import org.mongodb.kbson.ObjectId;


open class Task(data:Map<String,Any>):Chore(data){
    @PrimaryKey
    var id=data["id"] as String;
    var chores=(data["chores"] as? List<Map<String,Any>> ?: listOf()).map { Chore(it) };

    /*override var done:Boolean
        get()=this.chores.all { it.done };
        set(value){
            this.chores.forEach { it.done=value };
        }*/
}

open class Chore(data:Map<String,Any>){
    var name=data["name"] as String;
    var description=data["description"] as? String ?: "";
    open var done=data["done"] as? Boolean ?: false;
}