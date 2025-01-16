package components.TaskView;

//import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.trash0
import org.jetbrains.compose.resources.painterResource
import resources.Task



@Composable
//@OptIn(ExperimentalMaterial3Api::class)
fun TaskView(
    task:Task,
    modifier:Modifier?=null,
    active:Boolean=true,
    onToggle:((Boolean)->Unit)?=null,
    onDelete:(()->Unit)?=null,
){
    val checked=remember {mutableStateOf(task.done)};

    Row(
        modifier=styles.taskview.modifier(modifier),
        verticalAlignment=styles.taskview.verticalAlignment,
        horizontalArrangement=styles.taskview.horizontalArrangement,
    ){
        Row(
            modifier=Modifier.weight(1f,true),
            verticalAlignment=styles.details.verticalAlignment,
        ){
            Checkbox(
                checked=checked.value,
                modifier=styles.checkbox.modifier,
                colors=styles.checkbox.colors,
                onCheckedChange={ value ->
                    task.done=value;
                    checked.value=value;
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
        IconButton(onClick={onDelete?.invoke()}){
            Icon(
                contentDescription="delete",
                tint=styles.deletebtn.tint,
                painter=painterResource(Res.drawable.trash0),
            )
        }
    }
}
