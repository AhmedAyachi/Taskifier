package components.TaskView;

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
            height(150.dp).
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
                horizontal=(Theme.spacingHorizontal),
            ).
            clipToBounds()
        ;
    }
    object details {
        val modifer=Modifier;
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
        val modifier=Modifier.
            fillMaxWidth().
            padding(top=5.dp)
        ;
        val textDecoration={ done:Boolean ->
            if(done) TextDecoration.LineThrough else null
        };
    }
    object contextbtn {
        val modifier=Modifier.
            size(30.dp).
            padding(start=5.dp)
        ;
    }
}
