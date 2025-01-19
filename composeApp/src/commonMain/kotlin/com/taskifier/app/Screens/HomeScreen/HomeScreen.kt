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
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.LoadingView.LoadingView
import components.ScreenView.ScreenView
import components.TaskView.TaskView
import components.header.Header
import screens.taskscreen.TaskScreen


class HomeScreen:ScreenView(
    modifier=styles.homescreen.modifier,
    children={
        val navigator=LocalNavigator.currentOrThrow;
        var tasks by rememberTasks();
        val newTask=rememberNewTask { tasks=listOf(it)+tasks!! };
        val listState=rememberListState(tasks);



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
                            tasks=tasks?.filter {it!=task};
                        }
                    );
                }
            };
        }
    }
);
