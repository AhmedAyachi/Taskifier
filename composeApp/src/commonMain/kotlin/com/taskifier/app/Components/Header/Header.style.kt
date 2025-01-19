package components.header;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.taskifier.app.Theme


object styles {
    object header {
        val modifier={ modifier:Modifier -> Modifier.
            fillMaxWidth().
            padding(vertical=20.dp,horizontal=Theme.spacingHorizontal).
            then(modifier);
        }
    }
    object info {
        val modifier=Modifier;
        val arrangement=Arrangement.spacedBy(10.dp);
    }
    object backbtn {
        val modifier=Modifier.
            size(30.dp).
            graphicsLayer(translationX=-20f)
        ;
    }
    object title {
        val modifier=Modifier;
        val fontSize=5.em;
        val fontWeight=FontWeight.W700;
        val color=Theme.textColor;
    }
}
