package projectmanager.document;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
    @Id
    private String id;
    private String name;
    private String description;
    @DBRef
    @JsonBackReference
    private Project project;
    @DBRef
    private User assinedTo;
    private Boolean completed;
    @CreatedDate
    private LocalDate createdAt;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the assinedTo
     */
    public User getAssinedTo() {
        return assinedTo;
    }

    /**
     * @param assinedTo the assinedTo to set
     */
    public void setAssinedTo(User assinedTo) {
        this.assinedTo = assinedTo;
    }

    /**
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * @return the completed
     */
    public Boolean getCompleted() {
        return completed;
    }

    /**
     * @param completed the completed to set
     */
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}