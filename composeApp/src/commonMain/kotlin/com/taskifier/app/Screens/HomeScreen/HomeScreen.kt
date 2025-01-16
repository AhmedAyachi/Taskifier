package screens.homescreen;
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.taskifier.app.Theme
import components.LoadingView.LoadingView
import components.TaskView.TaskView
import components.header.Header
import resources.Task


class HomeScreen:Screen {
    
    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content(){
        var tasks by remember {mutableStateOf(listOf<Map<String,Any>>())};
        var loading by remember {mutableStateOf(true)};

        LaunchedEffect(Unit){
            try{
                val data=fetchTasks();
                tasks=data;
            }
            finally {
                loading=false;
            }
        }

        Scaffold(
            topBar={Header(
                title="my tasks",
            )},
            floatingActionButton={
                FloatingActionButton(
                    onClick={},
                    shape=RoundedCornerShape(size=12.dp),
                    containerColor=Theme.mainColor
                ){
                    Icon(
                        imageVector=Icons.Default.Edit,
                        contentDescription="Edit Icon",
                        tint=Theme.backgroundColor,
                    )
                }
            },
        ){ padding ->
            if(loading) LoadingView();
            Column(styles.tasks.modifier(padding)){
                LazyColumn {
                    itemsIndexed(
                        items=tasks,
                    ){ i,task ->
                        TaskView(
                            task=Task(task),
                            modifier=styles.taskview.modifier(i),
                            onDelete={
                                tasks=tasks.filter {it!=task};
                            }
                        );
                    }
                };
            };
        }
    }
}
