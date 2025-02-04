package br.com.eduardocouto.todo_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardocouto.todo_list.dto.TodoDto;
import br.com.eduardocouto.todo_list.entity.Todo;
import br.com.eduardocouto.todo_list.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    List<TodoDto> show() {
        return todoService.show();
    }

    @PostMapping
    List<TodoDto> create(@RequestBody Todo todo) {

        return todoService.create(todo);
    }

    @PutMapping
    List<TodoDto> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<TodoDto> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
