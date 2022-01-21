package com.example.Salon.Model.Service;

import com.example.Salon.Model.Entities.Employee;
import com.example.Salon.Model.Repository.EmployeeRepository;
import com.example.Salon.Model.Repository.ServicesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    ServicesRepository servicesRepository;
    @InjectMocks
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetEmployees() {
        List<Employee> result = employeeService.getEmployees();
        Assertions.assertEquals(Arrays.<Employee>asList(new Employee(0, "firstName", "lastName", "email", "password")), result);
    }

    @Test
    void testGetEmployee() {
        Optional<Employee> result = employeeService.getEmployee(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewEmployee() {
        employeeService.addNewEmployee(new Employee(0, "firstName", "lastName", "email", "password"));
    }

    @Test
    void testDeleteEmployee() {
        employeeService.deleteEmployee(Integer.valueOf(0));
    }

    @Test
    void testSetEmployeeService() {
        employeeService.setEmployeeService(Integer.valueOf(0), Integer.valueOf(0));
    }

    @Test
    void testGetEmployeesByService() {
        List<Employee> result = employeeService.getEmployeesByService(Integer.valueOf(0));
        Assertions.assertEquals(Arrays.<Employee>asList(new Employee(0, "firstName", "lastName", "email", "password")), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme