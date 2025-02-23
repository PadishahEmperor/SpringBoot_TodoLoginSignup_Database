package SpringJDBC7LoginTodo.SpringJDBC7LoginTodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"repositories", "services","model","controller"})
public class SpringJdbc7LoginTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbc7LoginTodoApplication.class, args);
	}

}
