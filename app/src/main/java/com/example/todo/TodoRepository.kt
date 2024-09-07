package com.example.todo

import com.example.todo.database.TodoDao
import com.example.todo.database.toDomain

class TodoRepository(private val dao: TodoDao) {
    suspend fun loadTodos(): List<Todo> {
        val entities = dao.getTodos()
        return entities.map { entity ->
            entity.toDomain()
        }
    }

    suspend fun insertTodo(todo: Todo) {
        val entity = todo.toEntity()
        dao.insertTodo(entity)
    }
}
