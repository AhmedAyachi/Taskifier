package components.LoadingView;

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.taskifier.app.Theme


@Composable
fun LoadingView(
    message:String?=null,
){
     Box(
        modifier=styles.loadingview.modifier,
        contentAlignment=Alignment.Center,
    ){
        if(message==null){
            CircularProgressIndicator(
                modifier=styles.indicator.modifier,
                color=styles.indicator.color,
            );
        }
        else{
            Text(
                text=message,
                color=Theme.textColor,
            );
        }
    }
}
