package projectmanager.repository;

import projectmanager.document.Project;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProjectRepository extends ReactiveMongoRepository<Project, String> {
}
