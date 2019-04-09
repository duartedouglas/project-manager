package projectmanager.config;

import projectmanager.document.Project;
import projectmanager.repository.ProjectRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import projectmanager.repository.TaskRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class InitData implements CommandLineRunner {

    private final ProjectRepository repository;
    private final TaskRepository taskRepository;

    InitData(ProjectRepository repository, TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        taskRepository.deleteAll().subscribe(System.out::println);

        repository.deleteAll().subscribe(System.out::println);
//                .thenMany(Flux.just("project 1", "project 2", "project 3")
//                        .map(n -> new Project(n, UUID.randomUUID().toString())))
//                .flatMap(repository::save).subscribe(System.out::println);
    }
}
