package com.todo_list.service;

import com.todo_list.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> list();

    List<Todo> create(Todo todo);

    List<Todo> update(Long id, Todo todo);

    List<Todo> delete(Long id);
}
