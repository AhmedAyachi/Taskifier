package screens.taskscreen;
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import components.ChoreList.ChoreList
import components.header.Header
import resources.Task
import resources.capitalize


class TaskScreen(
    val task:Task?=null,
):Screen {
    
    @Composable
    override fun Content(){
        Column(styles.taskscreen.modifier){
            Header(title=task?.name?:"new task".capitalize());
            ChoreList(
                chores=task?.chores,
                onChange={ task?.chores=it },
            );
        }
    }
}
