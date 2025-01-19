package components.ChoreList.ChoreInput;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.taskifier.app.Theme
import org.jetbrains.compose.resources.painterResource
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.plus0


@Composable
fun ChoreInput(onSubmit:((String)->Unit)?=null){
    Row(
        modifier=styles.choreinput.modifier,
        horizontalArrangement=Arrangement.spacedBy(5.dp),
        verticalAlignment=Alignment.CenterVertically,
    ){
        var value by remember {mutableStateOf("")};

        TextField(
            modifier=styles.input.modifier.weight(1f,true),
            value=value,
            onValueChange={ value=it },
            placeholder={Text(text="write chore ...")},
            minLines=1,
            maxLines=1,
            singleLine=true,
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
