package components.header;

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.taskifier.app.Theme
import components.ActionSet.ActionSet
import components.TextField.TextField
import org.jetbrains.compose.resources.painterResource
import resources.capitalize
import taskifier.composeapp.generated.resources.Res
import taskifier.composeapp.generated.resources.chevron0


@Composable
fun Header(
    title:String="",
    placeholder:String="",
    back:Boolean=true,
    actions:(Array<Map<String,Any>>?)=null,
    modifer:Modifier=Modifier,
    editable:Boolean=false,
    onTitleChange:((String)->Unit)?=null,
){
    val navigator=LocalNavigator.currentOrThrow;
    Row(
        modifier=styles.header.modifier(modifer),
        horizontalArrangement=Arrangement.SpaceBetween,
        verticalAlignment=Alignment.CenterVertically,
    ){
        Row(
            modifier=styles.info.modifier,
            horizontalArrangement=styles.info.arrangement,
            verticalAlignment=Alignment.CenterVertically,
        ){
            if(back) Icon(
                tint=Theme.textColor,
                contentDescription="",
                painter=painterResource(Res.drawable.chevron0),
                modifier=styles.backbtn.modifier.clickable {
                    navigator.pop();
                },
            )
            if(editable) TextField(
                modifier=styles.textfield.modifier,
                colors={it.copy(
                    focusedContainerColor=Color.Transparent,
                    unfocusedContainerColor=Color.Transparent,
                    unfocusedIndicatorColor=Color.Transparent,
                )},
                textStyle=TextStyle(
                    fontSize=styles.title.fontSize,
                    fontWeight=styles.title.fontWeight,
                ),
                value=title.capitalize(),
                placeholder=placeholder.capitalize(),
                onChange=onTitleChange,
            );
            else Text(
                modifier=styles.title.modifier,
                text=title.capitalize(),
                fontSize=styles.title.fontSize,
                fontWeight=styles.title.fontWeight,
                color=styles.title.color,
            )
        }
        if(actions!==null) ActionSet(
            tintColor=Theme.textColor,
            actions=actions,
        )
    }
}
