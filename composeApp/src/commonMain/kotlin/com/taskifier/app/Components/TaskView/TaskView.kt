package components.TaskView;
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.AlertView.AlertView
import components.LoadingView.LoadingView
import components.ProgressView.ProgressView
import components.TaskView.Hooks.saveTask
import components.contextmenu.ContextMenu
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
    var menuShown by remember {mutableStateOf(false)};
    var menuOffset by remember {mutableStateOf(Offset(0f,0f))};
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
                        text=task.name.ifEmpty { "--" }.capitalize(),
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
                        val offset=layout.positionInParent();
                        menuOffset=Offset(offset.x-220,offset.y+20);
                    },
                )
            }
            ProgressView(
                withPercentage=true,
                progress=task.progress,
            );
        }
        LoadingView(visible=taskId==null);
        AlertView(
            visible=showAlert,
            message="delete ${task.name}",
            onConfirm={onDelete?.invoke()},
            onCancel={showAlert=false}
        )

        ContextMenu(
            visible=menuShown,
            offset=menuOffset,
            options=listOf(
                if(task.done) mapOf();
                else mapOf(
                    "label" to "done",
                    "onTrigger" to { action:Map<String,Any?> ->
                        task.done=true;
                        checked=task.done;
                        menuShown=false;
                    }
                ),
                mapOf(
                    "label" to "delete",
                    "onTrigger" to { action:Map<String,Any?> ->
                        onDelete?.invoke();
                    },
                ),
            ).filter { it.isNotEmpty() },
            enterTransition=fadeIn()+scaleIn(
                animationSpec=tween(300),
                transformOrigin=TransformOrigin(1f,0f),
            ),
            exitTransition=fadeOut(tween(300))+scaleOut(
                animationSpec=tween(300),
                transformOrigin=TransformOrigin(1f,0f),
            ),
        )
    }
}
