package br.com.eduardocouto.todo_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.eduardocouto.todo_list.dto.TodoDto;
import br.com.eduardocouto.todo_list.entity.Todo;
import br.com.eduardocouto.todo_list.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // Injeção de dependência por meio de um construtor
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDto> create(Todo todo) {
        todoRepository.save(todo);
        return show();
    }

    public List<TodoDto> show() {

        // Sort sort = Sort.by("prioridade").descending().and(
        //         Sort.by("nome").ascending());

        List<Todo> result = todoRepository.findAll();

        return result.stream().map(x-> new TodoDto(x)).toList();

         
    }

    // public List<Todo> update(Todo todo) {
    //     todoRepository.save(todo);
    //     return show();
    // }

    // public List<Todo> delete(Long id) {
    //     todoRepository.deleteById(id);
    //     ;
    //     return show();
    // }

}
