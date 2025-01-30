package br.com.eduardocouto.todo_list.dto;

import br.com.eduardocouto.todo_list.entity.Todo;

public class TodoDto {
    private Long id;
    private String nome;
    private String descricao;

    public TodoDto() {

    }

    public TodoDto(Todo entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
