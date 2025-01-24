package br.com.eduardocouto.todo_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.eduardocouto.todo_list.entity.Todo;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {
@Autowired
private WebTestClient webTestClient;
	@Test
	void testCreateTodoSuccess() {

		var todo = new Todo("todo 1", "desc 1", false, 10);
		webTestClient.
		post()
		.uri("/todos")
		.bodyValue(todo)
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.jsonPath("$").isArray()
		.jsonPath("$.length()").isEqualTo(1)
		.jsonPath("$[0].nome").isEqualTo(todo.getNome())
		.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
		.jsonPath("$[0].concluido").isEqualTo(todo.isConcluido())
		.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
		
	}

	@Test
	void testCreateTodoFailure() {
	}
}
