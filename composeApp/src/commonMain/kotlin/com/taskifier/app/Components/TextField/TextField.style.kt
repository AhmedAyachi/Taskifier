package components.TextField;

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.taskifier.app.Theme


object styles {
    object textfield {
        val modifier=Modifier.
            clip(RoundedCornerShape(10.dp))
        ;
        val colors=@Composable {
            TextFieldDefaults.colors(
            focusedTextColor= Theme.textColor,
            unfocusedTextColor= Theme.textColor,
            focusedPlaceholderColor= Theme.textColor.copy(0.5f),
            unfocusedPlaceholderColor= Theme.textColor.copy(0.5f),
            focusedContainerColor= Theme.textColor.copy(0.15f),
            unfocusedContainerColor= Theme.textColor.copy(0.15f),
            focusedIndicatorColor= Theme.mainColor,
        )};
    }
}
