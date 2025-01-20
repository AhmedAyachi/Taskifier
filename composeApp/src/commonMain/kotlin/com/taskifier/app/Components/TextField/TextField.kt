package components.TextField;

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.em
import androidx.compose.material3.TextField as MaterialTextField


@Composable
fun TextField(
    modifier:Modifier=Modifier,
    value:String?=null,
    placeholder:String="",
    multiline:Boolean=false,
    textStyle:TextStyle?=null,
    colors:((TextFieldColors)->TextFieldColors)={it},
    onChange:((String)->Unit)?=null,
    onSubmit:((String)->Any?)?=null,
){
    var text by remember {mutableStateOf(value?:"")};
    val focusManager=LocalFocusManager.current;


    LaunchedEffect(text){
        onChange?.invoke(text.trim());
    }
    LaunchedEffect(value){
        if(value!==null) text=value.trim();
    }

    MaterialTextField(
        modifier=styles.textfield.modifier.then(modifier),
        value=text,
        textStyle=TextStyle.Default.copy(
            fontSize=4.em,
            lineHeight=1.5.em,
        ).merge(textStyle),
        colors=colors(styles.textfield.colors()),
        placeholder={ Text(text=placeholder) },
        singleLine=!multiline,
        onValueChange={ text=it },
        keyboardActions=KeyboardActions(
            onDone={
                text=text.trim();
                val shouldBlur=onSubmit?.invoke(text) as? Boolean ?: true;
                if(shouldBlur){
                    focusManager.clearFocus();
                }
            },
        ),
    );
}
