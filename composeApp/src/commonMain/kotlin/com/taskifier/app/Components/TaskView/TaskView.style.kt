package components.TaskView;

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CheckboxColors
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.taskifier.app.Theme


object styles {
    object taskview {
        val modifier={ style:Modifier -> Modifier.
            height(135.dp).
            then(style).
            clip(RoundedCornerShape(25f)).
            background(Brush.linearGradient(
                colorStops=arrayOf(
                    0.1f to Color(255f,255f,255f,0.05f),
                    0.2f to Theme.mainColor.copy(alpha=0.2f),
                    0.4f to Color(255f,255f,255f,0.05f),
                    0.8f to Theme.mainColor.copy(alpha=0.2f),
                    0.95f to Color(255f,255f,255f,0.05f),
                ),
            )).
            clipToBounds();
        }
    }
    object container {
        val modifier=Modifier.
            fillMaxSize().
            border(0.dp,Color.Transparent).
            padding(
                vertical=10.dp,
                horizontal=(Theme.spacingHorizontal/3),
            ).
            clipToBounds()
        ;
        val alignment=Alignment.CenterVertically;
        val arrangement=Arrangement.SpaceBetween;
    }
    object details {
        val alignment=Alignment.CenterVertically;
    }
    object checkbox {
        val modifier=Modifier.
            padding(0.dp).
            padding(end=8.dp)
        ;
        val colors=CheckboxColors(
            checkedBoxColor=Theme.mainColor,
            uncheckedBoxColor=Theme.textColor,
            disabledCheckedBoxColor=Theme.textColor,
            disabledBorderColor=Theme.mainColor,
            checkedBorderColor=Theme.mainColor,
            uncheckedBorderColor=Theme.mainColor,
            checkedCheckmarkColor=Theme.textColor,
            uncheckedCheckmarkColor=Color.Transparent,
            disabledUncheckedBoxColor=Color.Black,
            disabledIndeterminateBorderColor=Color.Black,
            disabledUncheckedBorderColor=Color.Black,
            disabledIndeterminateBoxColor=Color.Black,
        );
    }
    object name {
        val modifier={ active:Boolean -> Modifier.
            alpha(if(active) 1f else 0.5f)
        };
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
