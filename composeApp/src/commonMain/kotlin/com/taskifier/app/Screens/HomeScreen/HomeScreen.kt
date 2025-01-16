package screens.homescreen;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar;
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold;
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen;
import com.taskifier.app.LocalDB
import com.taskifier.app.Theme
import components.LoadingView.LoadingView
import components.TaskView.TaskView;
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import resources.Task


class HomeScreen : Screen {
    
    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content(){
        val tasks=remember {mutableStateOf(listOf<Map<String,Any>>())};
        val loading=remember {mutableStateOf(true)};

        LaunchedEffect(true){
            try{
                val data=fetchTasks();
                tasks.value=data;
            }
            finally {
                loading.value=false;
            }

        }

        Scaffold(
            topBar={
                CenterAlignedTopAppBar(
                    title={Text(text="Home")},
                    colors=styles.topbar.colors,
                );
            },
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

            if(loading.value) LoadingView();
            Column(styles.tasks.modifier(padding)){
                LazyColumn {
                    itemsIndexed(
                        items=tasks.value,
                    ){ i,task ->
                        TaskView(
                            task=Task(task),
                            modifier=styles.taskview.modifier(i),
                            onDelete={
                                tasks.value=tasks.value.filter {it!=task};
                            }
                        );
                    }
                };
            };
        }
    }
}
