package projectmanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projectmanager.document.Project;
import projectmanager.document.Task;
import projectmanager.repository.ProjectRepository;
import projectmanager.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "project")
public class ProjectController {

    private final ProjectRepository repository;
    private final TaskRepository taskRepository;

    @Autowired
    public ProjectController(ProjectRepository repository, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public Flux<Project> listProjects() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Mono<Project> getProject(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Project> createProject(@RequestBody Project project) {
        List<Task> tasks = List.copyOf(project.getTasks());
        project.setTasks(new ArrayList<>());

        return repository.insert(project).flatMap(p -> {
            if (!tasks.isEmpty()) {
                return saveTasksOnProject(tasks, p);
            }
            return Mono.just(p);
        });
    }

    @PutMapping(path = "/{id}")
    public Mono<Project> updateProject(@PathVariable("id") String id, @RequestBody Project project) {
        project.setId(id);
        List<Task> tasks = List.copyOf(project.getTasks());
        project.setTasks(new ArrayList<>());

        return repository.findById(id).flatMap(taskRepository::deleteByProject).thenReturn(
                repository.save(project).flatMap(p -> {
            if (!tasks.isEmpty()) {
                return saveTasksOnProject(tasks, p);
            }
            return Mono.just(p);
        })
        ).flatMap(e -> e);
    }

    @DeleteMapping(path = "/{id}")
    public Mono<Void> deleteProject(@PathVariable("id") String id) {
        return repository.findById(id).flatMap(project ->  {
            return taskRepository.deleteByProject(project).thenReturn(repository.delete(project));
        }).flatMap(e -> e);

    }

    private Mono<? extends Project> saveTasksOnProject(List<Task> tasks, Project project) {
        List<Task> newTasks = tasks.stream().map(task -> {
            task.setProject(project);
            return task;
        }).collect(Collectors.toList());
        return taskRepository.saveAll(newTasks).map(task -> {
            project.getTasks().add(task);
            return task;
        }).then(repository.save(project));
    }
}
