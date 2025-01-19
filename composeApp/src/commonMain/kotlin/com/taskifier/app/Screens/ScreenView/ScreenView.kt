package components.ScreenView;

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import cafe.adriel.voyager.core.screen.Screen


open class ScreenView(
    val modifier:Modifier?=null,
    val children:@Composable ()->Unit,
):Screen {

    @Composable
    override fun Content(){
        val focusManager=LocalFocusManager.current;
        Column(styles.screenview.modifier.then(modifier?:Modifier).clickable {
            focusManager.clearFocus();
        }){
            children();
        }
    }
}
