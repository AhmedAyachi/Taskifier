package components.ChoreList.ChoreInput;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.taskifier.app.Theme
import components.TextField.TextField
import org.jetbrains.compose.resources.painterResource
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.plus0


@Composable
fun ChoreInput(onSubmit:((String)->Unit)?=null){
    Row(
        horizontalArrangement=Arrangement.spacedBy(5.dp),
        verticalAlignment=Alignment.CenterVertically,
        modifier=styles.choreinput.modifier,
    ){
        var value by remember {mutableStateOf("")};

        TextField(
            modifier=Modifier.weight(1f,true),
            value=value,
            placeholder="write chore ...",
            onChange={ value=it },
            onSubmit={
                value="";
                onSubmit?.invoke(it);
                false;
            },
        );
        IconButton(
            onClick={
                if(value.isNotEmpty()){
                    onSubmit?.invoke(value);
                    value="";
                }
            },
        ){
            Icon(
                tint=Theme.textColor,
                contentDescription="",
                painter=painterResource(Res.drawable.plus0),
            )
        }
    }
}
