package screens.taskscreen;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import components.ChoreList.ChoreList
import components.ProgressView.ProgressView
import components.ScreenView.ScreenView
import components.TextField.TextField
import components.header.Header
import resources.Task


class TaskScreen(val task:Task=Task()):ScreenView(
    modifier=styles.taskscreen.modifier,
    children={
        var progress by remember {mutableStateOf(task.progress)};

        Header(
            title=task.name,
            placeholder=task.name.ifEmpty { "task name" },
            editable=true,
            onTitleChange={ task.name=it },
        )
        Column(
            modifier=styles.container.modifier,
            verticalArrangement=Arrangement.spacedBy(20.dp),
        ){
            ProgressView(
                progress=progress,
                withPercentage=true,
            )
            TextField(
                value=task.description,
                modifier=styles.textfield.modifier,
                placeholder="task description",
                multiline=true,
                onChange={ task.description=it },
            )
            ChoreList(
                chores=task.chores,
                onChange={
                    task.chores=it;
                    progress=task.progress;
                },
            );
        }
    }
);
