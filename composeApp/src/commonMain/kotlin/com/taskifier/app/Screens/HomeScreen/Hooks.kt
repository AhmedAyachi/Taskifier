package screens.homescreen;

import com.taskifier.app.LocalDB
import kotlinx.coroutines.delay;


suspend fun fetchTasks():List<Map<String,Any>> {
    delay(3000);
    return LocalDB.tasks;
}
