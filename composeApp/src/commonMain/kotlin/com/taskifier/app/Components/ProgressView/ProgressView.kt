package components.ProgressView;

import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.taskifier.app.Theme


@Composable
fun ProgressView(
    progress:Float=0.0f,
    animDuration:Int=500,
    withPercentage:Boolean=false,
){
    var animated by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit){
        animated=true;
    }

    Row(
        modifier=styles.progressview.modifier,
        horizontalArrangement=Arrangement.SpaceBetween,
        verticalAlignment=Alignment.CenterVertically,
    ){
        BoxWithConstraints(styles.bar.modifier.weight(1f)){
            val width by animateDpAsState(
                label="width",
                targetValue=if(animated) maxWidth*progress else 0.dp,
                animationSpec=tween(
                    delayMillis=0,
                    durationMillis=animDuration,
                    easing=EaseOut,
                ),
            )
            Box(styles.progress.modifier.width(width));
        }
        if(withPercentage) Text(
            modifier=styles.text.modifier,
            text=(progress*100).toInt().toString()+"%",
            fontSize=3.em,
            fontWeight=FontWeight.W700,
            color=Theme.textColor,
        )
    }
}
