package components.ActionSet;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.taskifier.app.Theme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


@Composable
fun ActionSet(
    tintColor:Color=Theme.mainColor,
    actions:Array<Map<String,Any>>,
){
    Row(
        modifier=styles.actionset.modifier,
        horizontalArrangement=Arrangement.spacedBy(20.dp),
        verticalAlignment=Alignment.CenterVertically,
    ){
        actions?.forEach { action ->
            val icon=action["icon"] as? DrawableResource;
            IconButton(
                modifier=styles.action.modifier,
                onClick={
                    val onTrigger=action["onTrigger"] as? ((Map<String,Any>)->Unit);
                    onTrigger?.invoke(action);
                },
            ){
                if(icon!==null){
                    Icon(
                        tint=tintColor,
                        modifier=styles.icon.modifier,
                        contentDescription="",
                        painter=painterResource(icon),
                    )
                }
            }
        }
    }
}
