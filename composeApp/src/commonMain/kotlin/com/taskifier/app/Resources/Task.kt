package resources;

import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.datetime.Clock

//import org.mongodb.kbson.ObjectId;

class Task(data:Map<String,Any?>):Chore(data){
    @PrimaryKey
    var id=data["id"] as? String;
    var name=data["name"] as String;
    var assignedAt:Long=data["assignedAt"] as? Long ?: 0;
    var chores:List<Chore> = (data["chores"] as? List<Map<String,Any?>> ?: listOf()).map { Chore(it) }

    override var done:Boolean
        get(){
            val chores=this.chores;
            return chores.isNotEmpty()&&chores.all { it.done };
        }
        set(value){
            chores.forEach { it.done=value };
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

    constructor(name:String=""):this(mapOf("name" to name)){
        this.assignedAt=Clock.System.now().toEpochMilliseconds();
    };
}

open class Chore(data:Map<String,Any?>){
    var description=data["description"] as? String ?: "";
    open var done=data["done"] as? Boolean ?: false;

    constructor(description:String):this(mapOf(
        "description" to description
    ));
}