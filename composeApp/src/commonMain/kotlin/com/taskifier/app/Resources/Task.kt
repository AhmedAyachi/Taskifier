package resources;

import io.realm.kotlin.types.annotations.PrimaryKey

//import org.mongodb.kbson.ObjectId;

class Task(data:Map<String,Any?>):Chore(data){
    @PrimaryKey
    var id=data["id"] as? String;
    var name=data["name"] as String;
    var chores:List<Chore> = (data["chores"] as? List<Map<String,Any?>> ?: listOf()).map { Chore(it) }

    override var done:Boolean=super.done
        get(){
            val chores=this.chores;
            return chores.isNotEmpty()&&chores.all { it.done };
        }

    val progress:Float
        get(){
            return if(this.done) 1f;
            else{
                val chores=this.chores;
                return if(chores.isEmpty()) 0f;
                else this.chores.count { it.done }/chores.count().toFloat();
            }
        }

    constructor(name:String=""):this(mapOf("name" to name));
}

open class Chore(data:Map<String,Any?>){
    var description=data["description"] as? String ?: "";
    open var done=data["done"] as? Boolean ?: false;

    constructor(description:String):this(mapOf(
        "description" to description
    ));
}