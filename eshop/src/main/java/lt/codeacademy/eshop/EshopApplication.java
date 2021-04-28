package lt.codeacademy.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class EshopApplication {

	public static void main(String[] args) {
		// Set profile on application statUp
		/*ConfigurableEnvironment environment = new StandardEnvironment();
		environment.setActiveProfiles("production");

		SpringApplication application = new SpringApplication(EshopApplication.class);
		application.setEnvironment(environment);
		application.run(args);*/

		SpringApplication.run(EshopApplication.class, args);
	}

}
