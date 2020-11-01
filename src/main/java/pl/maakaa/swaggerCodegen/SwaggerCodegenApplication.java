package pl.maakaa.swaggerCodegen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SwaggerCodegenApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello from an app that creates a Docker image";
	}

	public static void main(String[] args) {
		SpringApplication.run(SwaggerCodegenApplication.class, args);
	}

}
