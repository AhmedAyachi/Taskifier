package components.AlertView;

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import resources.capitalize


@Composable
fun AlertView(
    visible:Boolean=false,
    message:String?=null,
    modifier:Modifier=Modifier,
    onCancel:(()->Unit)?=null,
    onConfirm:(()->Unit)?=null,
    actions:(Array<Map<String,Any>>)=getActions(onCancel,onConfirm),
){
    AnimatedVisibility(
        modifier=styles.fader.modifier.then(modifier),
        visible=visible,
        enter=fadeIn(),
        exit=fadeOut(),
    ){
        Column(styles.alertview.modifier){
            Column(
                modifier=styles.container.modifier,
                horizontalAlignment=styles.container.horizontalAlignment,
                verticalArrangement=styles.container.verticalArrangement,
            ){
                Text(
                    modifier=styles.message.modifier,
                    text=(message?:"").capitalize(),
                    color=styles.message.color,
                    fontSize=styles.message.fontSize,
                    textAlign=styles.message.textAlign,
                )
                Row(
                    modifier=styles.actions.modifier,
                    horizontalArrangement=styles.actions.arragement,
                ){
                    actions.forEach { action ->
                        Button(
                            modifier=styles.action.modifier.weight(1f),
                            contentPadding=styles.action.padding,
                            colors=styles.action.colors,
                            onClick={
                                val onTrigger=action["onTrigger"] as? (()->Unit);
                                onTrigger?.invoke();
                            },
                        ){
                            Text(
                                text=(action["label"] as? String ?:"--").capitalize(),
                                fontSize=styles.action.fontSize,
                            )
                        }
                    }
                }
            }
        }
    }
}

val getActions={ onCancel:(()->Unit)?,onConfirm:(()->Unit)? -> arrayOf(
    mapOf(
        "label" to "confirm",
        "onTrigger" to {onConfirm?.invoke()},
    ),
    mapOf(
        "label" to "cancel",
        "onTrigger" to {onCancel?.invoke()},
    ),
)}
