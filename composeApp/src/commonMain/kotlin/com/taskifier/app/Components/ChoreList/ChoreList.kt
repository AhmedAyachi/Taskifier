package components.ChoreList;

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.ChoreList.ChoreInput.ChoreInput
import components.ChoreList.ChoreView.ChoreView
import resources.Chore


@Composable
fun ChoreList(
    modifier:Modifier=Modifier,
    chores:List<Chore>?=null,
    onChange:((List<Chore>)->Unit)?=null,
){
    Column(
        modifier=styles.chorelist.modifer.then(modifier),
        verticalArrangement=Arrangement.spacedBy(20.dp),
    ){
        var items by remember {mutableStateOf(chores?:listOf())};

        ChoreInput(
            onSubmit={ text ->
                items=listOf(Chore(text))+items;
                onChange?.invoke(items);
            }
        );
        Column(
            modifier=Modifier.verticalScroll(
                state=ScrollState(0),
                enabled=true,
            ),
            verticalArrangement=Arrangement.spacedBy(10.dp),
        ){
            items.forEach { chore ->
                ChoreView(
                    chore=chore,
                    onChange={
                        //items=items;
                        onChange?.invoke(items);
                    },
                    onDelete={
                        items=items.filter { chore!==it };
                        onChange?.invoke(items);
                    }
                );
            }
        }
    }
}
