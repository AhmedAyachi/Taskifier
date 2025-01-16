package screens.homescreen;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.taskifier.app.Theme


@OptIn(ExperimentalMaterial3Api::class)
object styles {
    object topbar {
        val colors=TopAppBarColors(
            containerColor=Theme.mainColor,
            titleContentColor=Theme.backgroundColor,
            scrolledContainerColor=Color.Transparent,
            actionIconContentColor=Color.Transparent,
            navigationIconContentColor=Color.Black,
        );
    }
    object tasks {
        val modifier={ padding:PaddingValues ->
            Modifier.fillMaxSize().padding(
                top=padding.calculateTopPadding(),
                bottom=padding.calculateBottomPadding(),
            )
        }
    }
    object taskview {
        val modifier={ i:Int -> Modifier.
            background(
                color=if(i%2==0) Theme.minorColor else Theme.backgroundColor,
            )
        }
    }
}
