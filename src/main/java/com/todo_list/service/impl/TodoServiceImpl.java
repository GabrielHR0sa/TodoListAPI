package com.todo_list.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.todo_list.entity.Todo;
import com.todo_list.exception.BadRequestException;
import com.todo_list.repository.TodoRepository;
import com.todo_list.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> list() {
        Sort sort = Sort.by(Direction.DESC, "priority")
            .and(Sort.by(Direction.ASC, "id"));

        return todoRepository.findAll(sort);
    }

    @Override
    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);

        return list();
    }

    @Override
    public List<Todo> update(Long id, Todo todo) {
       todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id);
            todoRepository.save(todo);
       }, () -> {
            throw new BadRequestException("Todo %d don't exist".formatted(id));
       });

       return list();
    }

    @Override
    public List<Todo> delete(Long id) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> todoRepository.delete(existingTodo), () -> {
            throw new BadRequestException("Todo %d don't exist".formatted(id));
        });
        
        return list();
    }

   
}
