package components.ChoreList.ChoreView;

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.taskifier.app.Theme
import org.jetbrains.compose.resources.painterResource
import resources.Chore
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.minus0


@Composable
fun ChoreView(
    chore:Chore,
    onChange:((Boolean)->Unit)?=null,
    onDelete:(()->Unit)?=null,
){
    var checked by remember(chore.description){mutableStateOf(chore.done)};

    Row(
        modifier=styles.choreview.modifier,
        horizontalArrangement=Arrangement.spacedBy(10.dp),
        verticalAlignment=Alignment.CenterVertically,
    ){
        Checkbox(
            modifier=styles.checkbox.modifier,
            colors=styles.checkbox.colors,
            checked=checked,
            onCheckedChange={ value ->
                chore.done=value;
                checked=value;
                onChange?.invoke(checked);
            },
        )
        Text(
            modifier=styles.description.modifier.weight(1f,true),
            text=chore.description,
            color=Theme.textColor,
            textDecoration=if(checked) TextDecoration.LineThrough else null,
        )
        Icon(
            tint=Theme.textColor,
            contentDescription=null,
            painter=painterResource(Res.drawable.minus0),
            modifier=styles.deletebtn.modifier.clickable {
                onDelete?.invoke();
            },
        )
    }
}
