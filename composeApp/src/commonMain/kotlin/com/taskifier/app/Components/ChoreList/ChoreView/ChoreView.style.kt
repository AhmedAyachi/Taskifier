package components.ChoreList.ChoreView;

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CheckboxColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.taskifier.app.Theme


object styles {
    object choreview {
        val modifier=Modifier.
            fillMaxWidth().
            padding(end=15.dp)
        ;
    }
    object checkbox {
        val modifier=Modifier.
            padding(0.dp).
            padding(end=8.dp)
        ;
        val colors=CheckboxColors(
            checkedBoxColor=Theme.mainColor,
            uncheckedBoxColor=Theme.textColor,
            disabledCheckedBoxColor=Theme.textColor,
            disabledBorderColor=Theme.mainColor,
            checkedBorderColor=Theme.mainColor,
            uncheckedBorderColor=Theme.textColor,
            checkedCheckmarkColor=Theme.textColor,
            uncheckedCheckmarkColor=Color.Transparent,
            disabledUncheckedBoxColor=Color.Black,
            disabledIndeterminateBorderColor=Color.Black,
            disabledUncheckedBorderColor=Color.Black,
            disabledIndeterminateBoxColor=Color.Black,
        );
    }
    object description {
        val modifier=Modifier;
    }
    object deletebtn {
        val modifier=Modifier.
            size(25.dp)
        ;
    }
}
