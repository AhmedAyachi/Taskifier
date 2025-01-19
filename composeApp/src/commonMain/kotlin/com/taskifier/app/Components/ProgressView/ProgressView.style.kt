package components.ProgressView;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.dp
import com.taskifier.app.Theme


object styles {
    object progressview {
        val modifier=Modifier
            //height(IntrinsicSize.Max)
        ;
    }
    object bar {
        val modifier=Modifier.
            height(5.dp).
            clip(RoundedCornerShape(5.dp)).
            background(Theme.textColor.copy(alpha=0.15f)).
            clipToBounds()
        ;
    }
    object progress {
        val modifier=Modifier.
            fillMaxHeight().
            background(Theme.mainColor)
        ;
    }
    object text {
        val modifier=Modifier.
            padding(start=10.dp)
        ;
    }
}
