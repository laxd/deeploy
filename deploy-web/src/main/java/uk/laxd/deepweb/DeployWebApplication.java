package uk.laxd.deepweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import uk.laxd.deepweb.executor.ExecutorManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource("classpath:dao-config.xml")
public class DeployWebApplication {

	@Autowired
	private ExecutorManager executorManager;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeployWebApplication.class, args);
	}

	@PostConstruct
	public void init() {
		executorManager.registerExecutors();
	}
}
