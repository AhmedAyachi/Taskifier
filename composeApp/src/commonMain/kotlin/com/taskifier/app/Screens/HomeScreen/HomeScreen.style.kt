package screens.homescreen;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.taskifier.app.Theme


object styles {
    object homescreen {
        val modifier=Modifier;
    }
    object tasks {
        val modifier={ padding:PaddingValues -> Modifier.
            fillMaxSize().
            padding(
                top=padding.calculateTopPadding(),
                bottom=padding.calculateBottomPadding(),
                start=Theme.spacingHorizontal,
                end=Theme.spacingHorizontal,
            );
        }
    }
    object taskview {
        val modifier=Modifier.padding(top=Theme.spacingHorizontal);
    }
    object  sortingmenu {
        val modifier=Modifier.background(Theme.mainColor.copy(0.05f));
    }
}
