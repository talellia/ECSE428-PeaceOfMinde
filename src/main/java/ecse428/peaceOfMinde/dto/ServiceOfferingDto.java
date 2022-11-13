package ecse428.peaceOfMinde.dto;

import java.time.LocalDateTime;

public class ServiceOfferingDto {

    private int workerId;
    private int id;
    private String title;
    private String description;
    private double hourlySalary;
    private LocalDateTime dateCreated;

    /**
     * @param workerId
     * @param id    
     * @param title
     * @param description
     * @param hourlySalary
     * @param dateCreated
     */
    public ServiceOfferingDto(int workerId, int id, String title, String description, 
                                double hourlySalary, LocalDateTime dateCreated) {
        this.workerId = workerId;
        this.id = id;
        this.title = title;
        this.description = description;
        this.hourlySalary = hourlySalary;
        this.dateCreated = dateCreated;
    }

    public int getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourlySalary() {
        return this.hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary= hourlySalary;
    }

    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
    
}
