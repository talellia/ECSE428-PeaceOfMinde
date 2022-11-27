package ecse428.peaceOfMinde.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class ServiceOffering {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer buyerId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Double hourlySalary;
    @Column
    private LocalDateTime dateCreated;
    /**
     * @param buyerId
     * @param id    
     * @param title
     * @param description
     * @param hourlySalary
     * @param dateCreated
     */
    public ServiceOffering(int buyerId, int id, String title, String description,
                                double hourlySalary, LocalDateTime dateCreated) {
        this.buyerId = buyerId;
        this.id = id;
        this.title = title;
        this.description = description;
        this.hourlySalary = hourlySalary;
        this.dateCreated = dateCreated;
    }

    public int getBuyerId() {
        return this.buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
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
