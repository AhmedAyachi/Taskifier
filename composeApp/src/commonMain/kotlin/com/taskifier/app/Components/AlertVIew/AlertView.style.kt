package components.AlertView;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.zIndex
import com.taskifier.app.Theme


object styles {
    object alertview {
        val modifier=Modifier.
            fillMaxSize().
            background(Theme.mainColor)
        ;
    }
    object fader {
        val modifier=Modifier.
            fillMaxSize().
            absoluteOffset().
            zIndex(99f)
        ;
    }
    object  container {
        val modifier=Modifier.
            fillMaxSize().
            padding(vertical=10.dp,horizontal=0.dp)
        ;
        val horizontalAlignment=Alignment.CenterHorizontally;
        val verticalArrangement=Arrangement.Center;
    }
    object message {
        val modifier=Modifier.padding(vertical=5.dp);
        val fontSize=5.em;
        val color=Theme.backgroundColor;
        val textAlign=TextAlign.Center;
    }
    object actions {
        val modifier=Modifier.fillMaxWidth(0.85f);
        val arragement=Arrangement.spacedBy(10.dp);
    }
    object action {
        val modifier=Modifier;
        val padding=PaddingValues(vertical=1.dp,horizontal=2.dp);
        val fontSize=4.em;
        val colors=ButtonColors(
            contentColor=Theme.mainColor,
            containerColor=Theme.backgroundColor,
            disabledContentColor=Theme.mainColor.copy(0.5f),
            disabledContainerColor=Theme.backgroundColor.copy(0.5f),
        );
    }
}
