package com.example.todo.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    suspend fun getTodos(): List<TodoEntity>

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodo(id: Int): TodoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)
}
