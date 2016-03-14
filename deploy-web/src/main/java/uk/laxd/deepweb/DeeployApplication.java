package uk.laxd.deepweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import uk.laxd.deepweb.plugin.PluginManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ImportResource("classpath:dao-config.xml")
public class DeeployApplication {

	@Autowired
	private PluginManager pluginManager;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeeployApplication.class, args);
	}

	@PostConstruct
	public void init() {
		pluginManager.registerPlugins();
	}
}
