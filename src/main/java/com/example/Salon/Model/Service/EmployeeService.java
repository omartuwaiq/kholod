package com.example.Salon.Model.Service;
import com.example.Salon.Model.Entities.Appointment;
import com.example.Salon.Model.Entities.Employee;
import com.example.Salon.Model.Entities.Services;
import com.example.Salon.Model.Repository.AppointmentRepository ;
import com.example.Salon.Model.Repository.EmployeeRepository;
import com.example.Salon.Model.Repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ServicesRepository servicesRepository ;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository ,ServicesRepository servicesRepository ) {
        this.employeeRepository = employeeRepository;
        this.servicesRepository = servicesRepository ;
    }
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }
    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
    public void setEmployeeService(Integer employeeId , Integer serviceId ) {
        Employee employee = employeeRepository.getById(employeeId) ;
        Services services = servicesRepository.getById(serviceId) ;
        employee.getEmpolyeeServices().add(services) ;
        employeeRepository.save(employee) ;
    }
    public List<Employee> getEmployeesByService( Integer serviceID ) {
        List<Employee> list ;
        list =  employeeRepository.findAll();
        List<Employee> finallist = new ArrayList<>() ;
        for (final Employee employee: list
             ) {
                Boolean test = false ;
            for (final Services services : employee.getEmpolyeeServices()){
                if(services.getId() == serviceID){
                    test=true ;
                }
            }
            if(test) {
                finallist.add(employee);
            }
        }
        return finallist ;
    }
}
