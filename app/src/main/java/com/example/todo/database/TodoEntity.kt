package com.example.todo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todo.ToDo

@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String
)

fun TodoEntity.toDomain() = ToDo(
    title = this.title,
    content = this.content
)
