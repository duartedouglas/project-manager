package projectmanager.controller;

import projectmanager.document.Task;
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
@RequestMapping(path = "task")
public class TaskController {

    @Autowired
    TaskRepository repository;

    @GetMapping
    public Flux<Task> listTasks() {
        Flux<Task> all = repository.findAll();

        return all;
    }

    @GetMapping(path = "/{id}")
    public Mono<Task> getTask(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Task> createTask(@RequestBody Task task) {
        return repository.insert(task);
    }

    @PutMapping
    public Mono<Task> updateTask(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping(path = "/{id}")
    public Mono<Void> deleteTask(@PathVariable("id") String id) {
        Mono<Void> delete = repository.deleteById(id);

        return delete;
    }
}
