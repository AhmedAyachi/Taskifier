package components.ActionSet;

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


object styles {
    object actionset {
        val modifier=Modifier;
    }
    object action {
        val modifier=Modifier.
            width(30.dp)
            //border(1.dp,Color.Black)
        ;
    }
    object icon {
        val modifier=Modifier.
            fillMaxWidth().
            fillMaxHeight()
        ;
    }
}
