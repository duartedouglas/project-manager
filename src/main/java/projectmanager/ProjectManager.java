package projectmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class ProjectManager {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManager.class, args);
	}

}
