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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.LoadingView.LoadingView
import components.TaskView.TaskView
import components.header.Header
import resources.Task
import screens.taskscreen.TaskScreen


class HomeScreen:Screen {
    
    @Composable
    override fun Content(){
        val navigator=LocalNavigator.currentOrThrow;
        var tasks by rememberSaveable {mutableStateOf<List<Task>?>(null)};

        LaunchedEffect(Unit){
            try{
                if(tasks===null) tasks=fetchTasks();
            }
            catch(error:Error){
                tasks=listOf();
            }
        }

        Scaffold(
            modifier=styles.homescreen.modifier,
            topBar={Header(
                title="my tasks",
                back=false,
            )},
            floatingActionButton={
                FloatingActionButton(
                    shape=RoundedCornerShape(size=12.dp),
                    containerColor=Theme.mainColor,
                    onClick={navigator.push(TaskScreen())},
                ){
                    Icon(
                        imageVector=Icons.Default.Edit,
                        contentDescription="Edit Icon",
                        tint=Theme.textColor,
                    )
                }
            },
        ){ padding ->
            if(tasks===null) LoadingView();
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
}
