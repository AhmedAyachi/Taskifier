package components.TaskView;
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.AlertView.AlertView
import components.LoadingView.LoadingView
import components.ProgressView.ProgressView
import components.TaskView.Hooks.saveTask
import org.jetbrains.compose.resources.painterResource
import resources.Task
import resources.capitalize
import screens.taskscreen.TaskScreen
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.dots0


@Composable
fun TaskView(
    task:Task,
    modifier:Modifier=Modifier,
    active:Boolean=true,
    onDelete:(()->Unit)?=null,
){
    val navigator=LocalNavigator.currentOrThrow;
    var taskId by remember {mutableStateOf(task.id)};
    //println("taskId $taskId");
    var menuShown by remember {mutableStateOf(false)};
    var menuOffset by remember {mutableStateOf<Offset?>(null)};
    var checked by remember {mutableStateOf(task.done)};
    var showAlert by remember {mutableStateOf(false)};


    LaunchedEffect(Unit){
        if(task.id==null){
            task.id=saveTask(task);
            taskId=task.id;
        }
    }

    Box(styles.taskview.modifier(modifier).clickable {
        navigator.push(TaskScreen(task));
    }){
        Column(
            modifier=styles.container.modifier,
            horizontalAlignment=Alignment.Start,
            verticalArrangement=Arrangement.SpaceBetween,
        ){
            Row(
                modifier=Modifier.weight(1f,true),
                verticalAlignment=Alignment.Top,
            ){
                Column(
                    modifier=Modifier.weight(1f,true),
                    verticalArrangement=Arrangement.SpaceBetween,
                ){
                    Text(
                        text=task.name?.capitalize()?:"",
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
                Icon(
                    contentDescription="",
                    tint=Theme.textColor,
                    painter=painterResource(Res.drawable.dots0),
                    modifier=styles.contextbtn.modifier.clickable {
                        menuShown=!menuShown;
                    }.onGloballyPositioned { layout ->
                        menuOffset=layout.positionInParent();
                        //println("menuOffset $menuOffset");
                    },
                )
            }
            ProgressView(
                withPercentage=true,
                progress=({
                    if(checked) 1f;
                    else task.progress;
                })(),
            );
        }
        LoadingView(visible=taskId==null);
        AlertView(
            visible=showAlert,
            message="delete ${task.name}",
            onConfirm={onDelete?.invoke()},
            onCancel={showAlert=false}
        )
        DropdownMenu(
            expanded=menuShown,
            onDismissRequest={menuShown=false},
            offset=DpOffset((menuOffset?.x ?: 0f).dp,-100.dp),
        ){
            arrayOf(
                mapOf(
                    "label" to "check",
                    "onTrigger" to {
                        task.done=!checked;
                        checked=task.done;
                    }
                ),
                mapOf(
                    "label" to "delete",
                    "onTrigger" to onDelete,
                ),
            ).forEach { option ->
                val label=option["label"] as String;
                val onTrigger=option["onTrigger"] as? (Map<String,Any?>)->Unit;
                DropdownMenuItem(
                    text={Text(text=label.capitalize())},
                    onClick={
                        onTrigger?.invoke(option);
                        println("Selected: $option")
                    }
                );
            }
        }
    }
}
