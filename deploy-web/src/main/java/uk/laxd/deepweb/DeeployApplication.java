package uk.laxd.deepweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dao-config.xml")
public class DeeployApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeeployApplication.class, args);
	}

}
