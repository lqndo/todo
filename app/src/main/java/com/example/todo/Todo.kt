package com.example.todo

import com.example.todo.database.TodoEntity

data class Todo(
    val id: Int? = null,
    val title: String,
    val content: String
)

fun Todo.toEntity() = TodoEntity(
    id = this.id,
    title = this.title,
    content = this.content
)
