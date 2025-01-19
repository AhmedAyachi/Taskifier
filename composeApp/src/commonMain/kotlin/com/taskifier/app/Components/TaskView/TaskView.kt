package components.TaskView;
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.AlertView.AlertView
import components.ProgressView.ProgressView
import org.jetbrains.compose.resources.painterResource
import resources.Task
import screens.taskscreen.TaskScreen
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.trash0


@Composable
fun TaskView(
    task:Task,
    modifier:Modifier=Modifier,
    active:Boolean=true,
    onToggle:((Boolean)->Unit)?=null,
    onDelete:(()->Unit)?=null,
){
    val navigator=LocalNavigator.currentOrThrow;
    var checked by remember(task.id) {mutableStateOf(task.done)};
    var showAlert by remember(task.id) {mutableStateOf(false)};

    Box(styles.taskview.modifier(modifier).clickable {
        navigator.push(TaskScreen(task));
    }){
        AlertView(
            visible=showAlert,
            message="delete ${task.name}",
            onConfirm={onDelete?.invoke()},
            onCancel={showAlert=false}
        )
        Row(
            modifier=styles.container.modifier,
            verticalAlignment=styles.container.alignment,
            horizontalArrangement=styles.container.arrangement,
        ){
            Row(
                modifier=Modifier.weight(1f,true),
                verticalAlignment=styles.details.alignment,
            ){
                Checkbox(
                    checked=checked,
                    modifier=styles.checkbox.modifier,
                    colors=styles.checkbox.colors,
                    onCheckedChange={ value ->
                        task.done=value;
                        checked=value;
                        onToggle?.invoke(value);
                    },
                );
                Column(
                    modifier=Modifier.fillMaxHeight(),
                    verticalArrangement=Arrangement.SpaceBetween,
                ){
                    Column {
                        Text(
                            text=task.name,
                            color=Theme.textColor,
                            modifier=styles.name.modifier(active),
                            fontSize=styles.name.fontSize,
                            textDecoration=styles.name.textDecoration(task.done),
                        );
                        Text(
                            text=task.description,
                            color=Theme.textColor,
                            modifier=styles.description.modifier,
                            textDecoration=styles.description.textDecoration(task.done),
                        )
                    }
                    ProgressView(
                        withPercentage=true,
                        progress=({
                            val done=task.done;
                            if(done) 1f;
                            else{
                                val chores=task.chores;
                                chores.count { it.done }/chores.count().toFloat();
                            }
                        })(),
                    );
                }
            }
            IconButton(onClick={showAlert=true}){
                Icon(
                    contentDescription="delete",
                    tint=styles.deletebtn.tint,
                    painter=painterResource(Res.drawable.trash0),
                )
            }
        }
    }
}
