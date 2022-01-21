package com.example.Salon.Model.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Appointment> items = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "employee_services",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id"))
    Set<Services> empolyeeServices;

    public Employee() {
    }
    public List<Appointment> getItems() {
        return items;
    }

    public void setItems(List<Appointment> items) {
        this.items = items;
    }

    public Set<Services> getEmpolyeeServices() {
        return empolyeeServices;
    }

    public void setEmpolyeeServices(Set<Services> empolyeeServices) {
        this.empolyeeServices = empolyeeServices;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
