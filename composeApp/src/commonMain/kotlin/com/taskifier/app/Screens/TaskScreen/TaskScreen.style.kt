package screens.taskscreen;
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.taskifier.app.Theme


object styles {
    object taskscreen {
        val modifier=Modifier.
            fillMaxSize().
            background(Theme.backgroundColor)
        ;
    }
}
