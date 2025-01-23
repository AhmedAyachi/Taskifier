package components.contextmenu;

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import resources.capitalize


@Composable
fun ContextMenu(
    visible:Boolean,
    offset:Offset=Offset(0f,0f),
    modifier:Modifier?=null,
    options:List<Map<String,Any?>>,
    onAction:(()->Unit)?=null,
    enterTransition:EnterTransition=fadeIn(),
    exitTransition:ExitTransition=fadeOut(),
){
    AnimatedVisibility(
        visible=visible,
        modifier=styles.contextmenu.modifier(offset),
        enter=enterTransition,
        exit=exitTransition,
    ){
        Column(
            modifier=styles.container.modifier.then(modifier?:Modifier),
            verticalArrangement=Arrangement.Top,
            //horizontalAlignment=Alignment.CenterHorizontally,
        ){
            options.forEachIndexed { i,option ->
                val label=option["label"] as? String ?: "";
                //val icon=option["icon"] as? DrawableResource;
                val onTrigger=option["onTrigger"] as? (Map<String,Any?>)->Unit;

                if(i>0) Spacer(styles.spacer.modifier);
                Row(
                    horizontalArrangement=Arrangement.SpaceBetween,
                    verticalAlignment=Alignment.CenterVertically,
                    modifier=styles.option.modifier.clickable {
                        onTrigger?.invoke(option);
                        onAction?.invoke();
                    },
                ){
                    Text(
                        modifier=styles.label.modifier,
                        style=styles.label.style,
                        text=label.capitalize(),
                    )
                }
            }
        }
    }
}
