package com.todo_list.controller;

import com.todo_list.dto.TodoDto;
import com.todo_list.service.impl.TodoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TodoController {

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    @PostMapping
    ResponseEntity<List<TodoDto>> create(@Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoServiceImpl.create(todoDto));
    }

    @GetMapping
    List<TodoDto> getAll() {
        return todoServiceImpl.getAll();
    }

    @PutMapping("{id}")
    List<TodoDto> update(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        return todoServiceImpl.update(id, todoDto);
    }

    @DeleteMapping("{id}")
    List<TodoDto> delete(@PathVariable Long id) {
        return todoServiceImpl.delete(id);
    }
}
