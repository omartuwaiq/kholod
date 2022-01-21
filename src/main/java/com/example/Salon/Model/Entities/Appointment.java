package com.example.Salon.Model.Entities;
import javax.persistence.*;

@Entity
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String time;
    @ManyToOne
    @JoinColumn(name= "employee_id" ,referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name= "customer_id" ,referencedColumnName = "id")
    private Customers customers ;
    @ManyToOne
    @JoinColumn(name= "services_id" ,referencedColumnName = "id")
    private Services services  ;

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Appointment() {
    }

    public Appointment(int id, String date, String time, int service_id, Employee employee, Customers customers, Services services) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.employee = employee;
        this.customers = customers;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
