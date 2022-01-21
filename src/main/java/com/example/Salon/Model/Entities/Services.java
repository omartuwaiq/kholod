package com.example.Salon.Model.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sname;
    private double price ;
    private String materials;
    private String photo ;
    @JsonIgnore
    @ManyToMany(mappedBy = "customerServices")
    Set<Customers> servicescustomer;
    @JsonIgnore
    @ManyToMany(mappedBy = "empolyeeServices")
    Set<Employee> servicesemployee;

    public List<Appointment> getItems() {
        return items;
    }

    public void setItems(List<Appointment> items) {
        this.items = items;
    }

    @OneToMany(mappedBy = "services")
    @JsonIgnore
    private List<Appointment> items = new ArrayList<>();

    public Set<Customers> getServicescustomer() {
        return servicescustomer;
    }

    public void setServicescustomer(Set<Customers> servicescustomer) {
        this.servicescustomer = servicescustomer;
    }

    public Set<Employee> getServicesemployee() {
        return servicesemployee;
    }

    public void setServicesemployee(Set<Employee> servicesemployee) {
        this.servicesemployee = servicesemployee;
    }

    public Services(int id, String sname, double price, String materials , String photo){

        this.id= id ;
        this.sname = sname ;
        this.price = price ;
        this.materials = materials ;
        this.photo = photo ;

    }
    public Services(){}

    public void setId(int id) {
        this.id = id;
    }
    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public double getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
