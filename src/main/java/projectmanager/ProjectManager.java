package projectmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.RedirectView;


@SpringBootApplication()
@Controller
@RequestMapping(path = "/")
public class ProjectManager {


	@GetMapping
    public RedirectView listProjects() {
        return new RedirectView("project");
    }

	public static void main(String[] args) {
		SpringApplication.run(ProjectManager.class, args);
	}

}
