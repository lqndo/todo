package com.example.todo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.Todo
import com.example.todo.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: TodoRepository
) : ViewModel() {
    private var _todos = MutableStateFlow(emptyList<Todo>())
    val todos: StateFlow<List<Todo>> = _todos

    init {
        viewModelScope.launch {
            _todos.value = loadTodos()
        }
    }

    private suspend fun loadTodos(): List<Todo> {
        return repository.loadTodos()
    }
}
