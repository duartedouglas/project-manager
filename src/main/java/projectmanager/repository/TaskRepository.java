package projectmanager.repository;

import projectmanager.document.Project;
import projectmanager.document.Task;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface TaskRepository extends ReactiveMongoRepository<Task, String> {

    Mono<Task> deleteByProject(Project p);
}
