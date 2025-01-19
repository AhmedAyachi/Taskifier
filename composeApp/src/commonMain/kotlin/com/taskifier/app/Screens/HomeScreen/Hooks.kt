package screens.homescreen;

import com.taskifier.app.AppConfig
import kotlinx.coroutines.delay
import localdb.LocalDB
import resources.Task


suspend fun fetchTasks():List<Task> {
    if(AppConfig.isDevEnv){
        delay(1000);
        return LocalDB.tasks.map { Task(it) };
    }
    else{
        return listOf();
    }
}
