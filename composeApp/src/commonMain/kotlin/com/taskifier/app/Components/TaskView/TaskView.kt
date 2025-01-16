package components.TaskView;
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import components.AlertView.AlertView
import org.jetbrains.compose.resources.painterResource
import resources.Task
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.trash0


@Composable
//@OptIn(ExperimentalMaterial3Api::class)
fun TaskView(
    task:Task,
    modifier:Modifier?=null,
    active:Boolean=true,
    onToggle:((Boolean)->Unit)?=null,
    onDelete:(()->Unit)?=null,
){
    var checked by remember(task.id) {mutableStateOf(task.done)};
    var showAlert by remember(task.id) {mutableStateOf(false)};

    Box(styles.taskview.modifier){
        AlertView(
            visible=showAlert,
            message="delete ${task.name}",
            onConfirm={
                onDelete?.invoke();
            },
            onCancel={
                showAlert=false;
            }
        )
        Row(
            modifier=styles.container.modifier(modifier),
            verticalAlignment=styles.container.verticalAlignment,
            horizontalArrangement=styles.container.horizontalArrangement,
        ){
            Row(
                modifier=Modifier.weight(1f,true),
                verticalAlignment=styles.details.verticalAlignment,
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
                Column {
                    Text(
                        text=task.name,
                        modifier=styles.name.modifier(active),
                        fontSize=styles.name.fontSize,
                        textDecoration=styles.name.textDecoration(task.done),
                    );
                    Text(
                        text=task.description,
                        modifier=styles.description.modifier,
                        textDecoration=styles.description.textDecoration(task.done),
                    )
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
