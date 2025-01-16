package components.header;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.taskifier.app.capitalize


@Composable
fun Header(
    title:String="",
){
    Row(
        modifier=styles.header.modifier,
        horizontalArrangement=Arrangement.SpaceBetween,
        verticalAlignment=Alignment.CenterVertically,
    ){
        Text(
            modifier=styles.title.modifier,
            text=title.capitalize(),
            fontSize=styles.title.fontSize,
            fontWeight=styles.title.fontWeight,
            color=styles.title.color,
        )
    }
}
