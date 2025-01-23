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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.LoadingView.LoadingView
import components.ScreenView.ScreenView
import components.TaskView.TaskView
import components.contextmenu.ContextMenu
import components.header.Header
import kotlinx.coroutines.launch
import screens.taskscreen.TaskScreen
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.list0


class HomeScreen:ScreenView(
    modifier=styles.homescreen.modifier,
    children={
        val navigator=LocalNavigator.currentOrThrow;
        var tasks by rememberTasks();
        val newTask=rememberNewTask { tasks=listOf(it)+tasks!! };
        val (coroutineScope,listState)=rememberListState(tasks);

        var sortingMenuShown by remember {mutableStateOf(false)};
        var sortingMenuOffset by remember {mutableStateOf(Offset(0f,0f))};

        Scaffold(
            containerColor=Color.Transparent,
            topBar={
                Header(
                    title="my tasks",
                    back=false,
                    actions=arrayOf(mapOf(
                        "icon" to Res.drawable.list0,
                        "modifier" to Modifier.onGloballyPositioned { layout ->
                            val offset=layout.positionInRoot();
                            println("offset $offset");
                            sortingMenuOffset=Offset(
                                offset.x-525,
                                offset.y
                            );
                        },
                        "onTrigger" to { sortingMenuShown=!sortingMenuShown },
                    )),
                )
                println("sortingMenuShown $sortingMenuShown");
                ContextMenu(
                    modifier=styles.sortingmenu.modifier,
                    visible=sortingMenuShown,
                    offset=sortingMenuOffset,
                    options=listOf(
                        mapOf(
                            "label" to "most recent",
                            "onTrigger" to { _:Map<String,Any?> ->
                                tasks=tasks?.sortedBy { -it.assignedAt };
                            },
                        ),
                        mapOf(
                            "label" to " least progress",
                            "onTrigger" to { _:Map<String,Any?> ->
                                tasks=tasks?.sortedBy { it.progress };

                            },
                        )
                    ),
                    onAction={
                        sortingMenuShown=false;
                        coroutineScope.launch {
                            listState.animateScrollToItem(index=0);
                        }
                    },
                );
            },
            floatingActionButton={
                FloatingActionButton(
                    shape=RoundedCornerShape(size=12.dp),
                    containerColor=Theme.mainColor,
                    onClick={navigator.push(TaskScreen(newTask))},
                ){
                    Icon(
                        imageVector=Icons.Default.Edit,
                        contentDescription="Edit Icon",
                        tint=Theme.textColor,
                    )
                }
            },
        ){ padding ->
            LoadingView(visible=tasks===null);
            LazyColumn(
                modifier=styles.tasks.modifier(padding),
                contentPadding=PaddingValues(vertical=Theme.spacingHorizontal),
                state=listState,
            ){
                itemsIndexed(
                    items=tasks?:listOf(),
                    key={i,task->task.id?:i},
                ){ _,task ->
                    TaskView(
                        task=task,
                        modifier=styles.taskview.modifier,
                        onDelete={
                            tasks=tasks?.filter {it.id!==task.id};
                        }
                    );
                }
            };
        }
    }
);
