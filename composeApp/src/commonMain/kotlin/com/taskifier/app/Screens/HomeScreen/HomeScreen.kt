package screens.homescreen;

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.LoadingView.LoadingView
import components.ScreenView.ScreenView
import components.TaskView.TaskView
import components.header.Header
import resources.Task
import screens.taskscreen.TaskScreen


class HomeScreen:ScreenView(
    modifier=styles.homescreen.modifier,
    children={
        val lifecycle=LocalLifecycleOwner.current.lifecycle;
        val navigator=LocalNavigator.currentOrThrow;
        var tasks by rememberSaveable {mutableStateOf<List<Task>?>(null)};
        var state by rememberSaveable {mutableStateOf(mapOf(
            "newTask" to Task(),
        ))};

        LaunchedEffect(Unit){
            try{
                if(tasks===null) tasks=fetchTasks();
            }
            catch(error:Error){
                tasks=listOf();
            }
        }
        LaunchedEffect(lifecycle){
            if(tasks!=null) lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
                val newTask=state["newTask"] as Task;
                if(newTask.chores.isNotEmpty()){
                    state+=mapOf("newTask" to Task());
                    tasks=listOf(newTask)+tasks!!;
                }
            }
        }

        Scaffold(
            containerColor=Color.Transparent,
            topBar={Header(
                title="my tasks",
                back=false,
            )},
            floatingActionButton={
                FloatingActionButton(
                    shape=RoundedCornerShape(size=12.dp),
                    containerColor=Theme.mainColor,
                    onClick={navigator.push(TaskScreen(state["newTask"] as Task))},
                ){
                    Icon(
                        imageVector=Icons.Default.Edit,
                        contentDescription="Edit Icon",
                        tint=Theme.textColor,
                    )
                }
            },
        ){ padding ->
            LoadingView(
                visible=tasks===null,
            );
            LazyColumn(
                modifier=styles.tasks.modifier(padding),
                contentPadding=PaddingValues(vertical=Theme.spacingHorizontal),
            ){
                itemsIndexed(
                    items=tasks?:listOf(),
                ){ i,task ->
                    TaskView(
                        task=task,
                        modifier=styles.taskview.modifier,
                        onDelete={
                            tasks=tasks?.filter {it!=task};
                        }
                    );
                }
            };
        }
    }
);
