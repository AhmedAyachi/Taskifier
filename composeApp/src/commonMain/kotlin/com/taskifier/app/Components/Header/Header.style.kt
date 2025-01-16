package components.header;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.taskifier.app.Theme


object styles {
    object header {
        val modifier=Modifier.
            fillMaxWidth().
            background(Theme.mainColor).
            padding(vertical=20.dp,horizontal=15.dp)
        ;
    }
    object title {
        val modifier=Modifier;
        val fontSize=5.em;
        val fontWeight=FontWeight.W700;
        val color=Theme.backgroundColor;
    }
}
