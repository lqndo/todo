package com.example.todo

import com.example.todo.database.TodoEntity

data class Todo(
    val title: String,
    val content: String
)

fun Todo.toEntity() = TodoEntity(
    title = this.title,
    content = this.content
)
