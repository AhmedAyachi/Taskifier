package components.contextmenu;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.taskifier.app.Theme


object styles {
    object contextmenu {
        val modifier=@Composable { offset:Offset ->
            val density=LocalDensity.current.density;
            Modifier.absoluteOffset(
                x=(offset.x/density).dp,
                y=(offset.y/density).dp,
            );
        };
    }
    object container {
        val modifier=Modifier.
            wrapContentWidth(unbounded=true).
            clip(RoundedCornerShape(30f)).
            padding(1.dp).
            background(Theme.backgroundColor.copy(0.85f)).
            clipToBounds();
    }
    object option {
        val modifier=Modifier.padding(vertical=10.dp,horizontal=20.dp);
    }
    object spacer {
        val modifier=Modifier.
            fillMaxWidth().
            //padding(vertical=1.dp,horizontal=2.dp).
            height(0.5f.dp).
            background(Theme.textColor.copy(0.25f))
        ;
    }
    object label {
        val modifier=Modifier;
        val style=TextStyle.Default.copy(
            fontSize=5.em,
            color=Theme.textColor.copy(0.65f),
        )
    }
}