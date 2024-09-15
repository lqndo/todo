package com.example.todo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.Todo
import com.example.todo.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(
    private val repository: TodoRepository
) : ViewModel() {
    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _content = MutableStateFlow("")
    val content: StateFlow<String> = _content

    fun loadTodo(id: Int) {
        viewModelScope.launch {
            val todo = repository.loadTodo(id)
            _title.value = todo.title
            _content.value = todo.content
        }
    }

    fun saveTodo() {
        val todo = Todo(
            title = _title.value,
            content = _content.value
        )
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }
}
