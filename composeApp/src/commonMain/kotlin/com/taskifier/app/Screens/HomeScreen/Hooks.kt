package screens.homescreen;

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.taskifier.app.AppConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import localdb.LocalDB
import resources.Task


@Composable
fun rememberListState(tasks:List<Task>?):Pair<CoroutineScope,LazyListState> {
    val listState=rememberLazyListState();
    val coroutineScope=rememberCoroutineScope();
    LaunchedEffect(tasks){
        val task=tasks?.get(0);
        if(task!=null){
            if(task.id===null){
                listState.scrollToItem(0);
            }
        }
    }
    return (coroutineScope to listState);
}

@Composable
fun rememberNewTask(onNewTask:(Task)->Unit):Task {
    val lifecycle=LocalLifecycleOwner.current.lifecycle;
    var state by rememberSaveable {mutableStateOf(mapOf("task" to Task()))};
    LaunchedEffect(lifecycle){
        lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
            val task=state["task"] as Task;
            if(task.chores.isNotEmpty()){
                state+=mapOf("task" to Task());
                onNewTask(task);
            }
        }
    }
    return state["task"] as Task;
}

@Composable
fun rememberTasks():MutableState<List<Task>?> {
    val tasks=rememberSaveable { mutableStateOf<List<Task>?>(null) };
    LaunchedEffect(Unit){
        try{
            if(tasks.value===null) tasks.value=fetchTasks();
        }
        catch(error:Error){
            tasks.value=listOf();
        }
    }
    return tasks;
}

suspend fun fetchTasks():List<Task> {
    if(AppConfig.isDevEnv){
        delay(1000);
        return LocalDB.tasks.map { Task(it) };
    }
    else{
        return listOf();
    }
}
