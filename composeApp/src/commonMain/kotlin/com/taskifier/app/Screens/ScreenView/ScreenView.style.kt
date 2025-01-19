package components.ScreenView;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.taskifier.app.Theme


object styles {
    object screenview {
        val modifier=Modifier.
            fillMaxWidth().
            fillMaxHeight().
            background(Theme.backgroundColor);
        ;
    }
}
