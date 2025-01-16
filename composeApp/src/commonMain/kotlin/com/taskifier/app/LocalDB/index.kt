package com.taskifier.app;
import kotlin.random.Random;


class LocalDB {
    companion object {
        val tasks=List(30){ i -> mapOf(
            "id" to "$i",
            "name" to "task_${i+1}",
            "description" to text.slice(0 until 95),
            "done" to (Random.nextFloat()>0.5),
        )}
    }
}

val text="""
    Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
    when an unknown printer took a galley of type and scrambled it to make 
    a type specimen book. It has survived not only five centuries, 
    but also the leap into electronic typesetting, remaining essentially unchanged. 
    It was popularised in the 1960s with the release of Letraset sheets containing 
    Lorem Ipsum passages, and more recently with desktop publishing software 
    like Aldus PageMaker including versions of Lorem Ipsum.
""".trimIndent().replace("\n","");

