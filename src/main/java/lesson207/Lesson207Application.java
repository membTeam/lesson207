package lesson207;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson207Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson207Application.class, args);
	}

	/*@Bean
	public CommandLineRunner dataLoader(EmploeesRepositories repo){

		return args -> {
			var configData = new ConfigrurationData();
			configData.LoadDataIntoDB(repo);
		};
	}*/

}
