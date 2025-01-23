package br.com.eduardocouto.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardocouto.todo_list.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
