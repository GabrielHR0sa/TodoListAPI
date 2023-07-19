package com.todo_list.service.impl;

import com.todo_list.dto.TodoDto;
import com.todo_list.repository.TodoRepository;
import com.todo_list.service.TodoService;

import java.util.List;

public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoDto> getAll() {
        return null;
    }

    @Override
    public List<TodoDto> create(TodoDto todoDto) {
        return null;
    }

    @Override
    public List<TodoDto> update(Long id, TodoDto todoDto) {
        return null;
    }

    @Override
    public List<TodoDto> delete(Long id) {
        return null;
    }
}
