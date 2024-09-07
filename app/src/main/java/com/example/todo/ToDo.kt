package com.example.todo

import com.example.todo.database.TodoEntity

data class ToDo(
    val title: String,
    val content: String
)

fun ToDo.toEntity() = TodoEntity(
    title = this.title,
    content = this.content
)
