package com.todo_list.service;

import com.todo_list.dto.TodoDto;
import com.todo_list.entity.Todo;

import java.util.List;

public interface TodoService {

    List<TodoDto> getAll();

    List<TodoDto> create(TodoDto todoDto);

    List<TodoDto> update(Long id, TodoDto todoDto);

    List<TodoDto> delete(Long id);
}
