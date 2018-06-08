package pl.parklinowy.server.entity;

import pl.parklinowy.server.enumType.RouteType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 1)
    private String firstName;

    @Size(min = 1)
    private String lastName;

    @Size(min = 1)
    private String identityCardNumber;

    @Size(min = 1)
    private String additionalText;

    @Enumerated(EnumType.STRING)
    private RouteType run;

    private boolean pay = true;

    private boolean isActive = true;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    public User() {
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    public RouteType getRun() {
        return run;
    }

    public void setRun(RouteType run) {
        this.run = run;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
