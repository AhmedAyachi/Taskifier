package components.header;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.taskifier.app.Theme
import com.taskifier.app.capitalize
import components.ActionSet.ActionSet
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.plus0


@Composable
fun Header(
    title:String="",
    actions:Array<Map<String,Any>>?=null,
){
    Row(
        modifier=styles.header.modifier,
        horizontalArrangement=Arrangement.SpaceBetween,
        verticalAlignment=Alignment.CenterVertically,
    ){
        Text(
            modifier=styles.title.modifier,
            text=title.capitalize(),
            fontSize=styles.title.fontSize,
            fontWeight=styles.title.fontWeight,
            color=styles.title.color,
        )
        ActionSet(
            tintColor=Theme.backgroundColor,
            actions=arrayOf( mapOf(
                "icon" to Res.drawable.plus0,
                "onTrigger" to { action:Map<String,Any> ->

                }
            ))
        )
    }
}
