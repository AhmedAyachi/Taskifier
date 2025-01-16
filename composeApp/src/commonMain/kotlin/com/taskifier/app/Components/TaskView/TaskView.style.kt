package components.TaskView;

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CheckboxColors
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.taskifier.app.Theme


object styles {
    object taskview {
        val modifier={ style:Modifier? -> Modifier.
            fillMaxWidth().
            fillMaxHeight().
            padding(horizontal=0.dp,vertical=0.dp).
            border(0.dp,Color.Transparent).
            then(style ?: Modifier).
            padding(horizontal=10.dp,vertical=10.dp)
        }
        val verticalAlignment=Alignment.CenterVertically;
        val horizontalArrangement=Arrangement.SpaceBetween;
    }
    object details {
        val verticalAlignment=Alignment.CenterVertically;
    }
    object checkbox {
        val modifier=Modifier.padding(
            end=8.dp,
        );
        val colors=CheckboxColors(
            checkedBoxColor=Theme.mainColor,
            uncheckedBoxColor=Theme.backgroundColor,
            disabledCheckedBoxColor=Theme.backgroundColor,
            disabledBorderColor=Theme.mainColor,
            checkedBorderColor=Theme.mainColor,
            uncheckedBorderColor=Theme.mainColor,
            checkedCheckmarkColor=Theme.backgroundColor,
            uncheckedCheckmarkColor=Color.Transparent,
            disabledUncheckedBoxColor=Color.Black,
            disabledIndeterminateBorderColor=Color.Black,
            disabledUncheckedBorderColor=Color.Black,
            disabledIndeterminateBoxColor=Color.Black,
        );
    }
    object name {
        val modifier={active:Boolean->Modifier.alpha(if(active) 1f else 0.5f)};
        val fontSize=5.em;//MaterialTheme.typography.bodyMedium.fontSize
        val textDecoration={ done:Boolean ->
            if(done) TextDecoration.LineThrough else null
        };
    }
    object description {
        val modifier=Modifier.fillMaxWidth();
        val textDecoration={ done:Boolean ->
            if(done) TextDecoration.LineThrough else null
        };
    }
    object deletebtn {
        val tint=Theme.mainColor;
    }
}
