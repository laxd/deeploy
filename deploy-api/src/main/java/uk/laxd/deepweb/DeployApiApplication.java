package uk.laxd.deepweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dao-config.xml")
public class DeployApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeployApiApplication.class, args);
	}
}
