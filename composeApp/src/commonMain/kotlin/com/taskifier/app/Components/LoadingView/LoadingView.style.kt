package components.LoadingView;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.taskifier.app.Theme


object styles {
    object loadingview {
        val modifier=Modifier.
            fillMaxSize().
            background(Theme.backgroundColor).
            padding(all=2.dp).
            zIndex(20f);
        ;
    }
    object indicator {
        val modifier=Modifier.size(28.dp);
        val color=Theme.mainColor;
    }
}
