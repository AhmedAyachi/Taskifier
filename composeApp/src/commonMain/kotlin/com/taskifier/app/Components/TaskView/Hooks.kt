package components.TaskView.Hooks;

import com.taskifier.app.AppConfig
import kotlinx.coroutines.delay
import resources.Task
import resources.randomId


suspend fun saveTask(task:Task):String {
    if(AppConfig.isDevEnv){
        delay(3000);
        return randomId();
    }
    else{
        return "";
    }
}


