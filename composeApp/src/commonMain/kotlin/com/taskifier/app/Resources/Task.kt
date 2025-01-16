package resources;

import io.realm.kotlin.types.RealmObject;
import io.realm.kotlin.types.annotations.PrimaryKey;
//import org.mongodb.kbson.ObjectId;


class Task(data:Map<String,Any>) : RealmObject {
    @PrimaryKey
    var id=data["id"] as String;
    var name=data["name"] as String;
    var description=data["description"] as? String ?: "";
    var done=data["done"] as? Boolean ?: false;
}