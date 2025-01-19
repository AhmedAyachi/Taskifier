package screens.taskscreen;
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.taskifier.app.Theme


object styles {
    object taskscreen {
        val modifier=Modifier;
    }
    object container {
        val modifier=Modifier.
            fillMaxSize().
            padding(horizontal=Theme.spacingHorizontal)
        ;
    }
    object textfield {
        val modifier=Modifier.
            fillMaxWidth()
        ;
    }
}
