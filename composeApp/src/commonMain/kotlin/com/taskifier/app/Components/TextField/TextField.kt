package components.TextField;

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.TextField as TextFieldComponent


@Composable
fun TextField(
    modifier:Modifier=Modifier,
    value:String?=null,
    placeholder:String="",
    multiline:Boolean=false,
    onChange:((String)->Unit)?=null,
){
    var text by remember {mutableStateOf(value?:"")};

    LaunchedEffect(text){
        onChange?.invoke(text);
    }
    LaunchedEffect(value){
        if(value!==null) text=value;
    }

    TextFieldComponent(
        modifier=styles.textfield.modifier.then(modifier),
        colors=styles.textfield.colors(),
        value=text,
        onValueChange={ text=it },
        placeholder={ Text(text=placeholder) },
        singleLine=!multiline,
    );
}
