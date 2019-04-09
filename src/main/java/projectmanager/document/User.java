package projectmanager.document;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String passwordResetToken;
    private LocalDate passwordResetExpiress;
    @CreatedDate
    private LocalDate createdAt;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the passwordResetExpiress
     */
    public LocalDate getPasswordResetExpiress() {
        return passwordResetExpiress;
    }

    /**
     * @param passwordResetExpiress the passwordResetExpiress to set
     */
    public void setPasswordResetExpiress(LocalDate passwordResetExpiress) {
        this.passwordResetExpiress = passwordResetExpiress;
    }

    /**
     * @return the passwordResetToken
     */
    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    /**
     * @param passwordResetToken the passwordResetToken to set
     */
    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}