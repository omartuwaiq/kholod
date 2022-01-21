package com.example.Salon.Controller;

import com.example.Salon.Model.Entities.Employee;
import com.example.Salon.Model.Service.EmployeeService;
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

class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;
    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetEmployees() {
        when(employeeService.getEmployees()).thenReturn(Arrays.<Employee>asList(new Employee(0, "firstName", "lastName", "email", "password")));

        List<Employee> result = employeeController.getEmployees();
        Assertions.assertEquals(Arrays.<Employee>asList(new Employee(0, "firstName", "lastName", "email", "password")), result);
    }

    @Test
    void testGetEmployeebyservice() {
        when(employeeService.getEmployeesByService(anyInt())).thenReturn(Arrays.<Employee>asList(new Employee(0, "firstName", "lastName", "email", "password")));

        List<Employee> result = employeeController.getEmployeebyservice(Integer.valueOf(0));
        Assertions.assertEquals(Arrays.<Employee>asList(new Employee(0, "firstName", "lastName", "email", "password")), result);
    }

    @Test
    void testGetEmployee() {
        when(employeeService.getEmployee(anyInt())).thenReturn(null);

        Optional<Employee> result = employeeController.getEmployee(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewEmployee() {
        employeeController.registerNewEmployee(new Employee(0, "firstName", "lastName", "email", "password"));
    }

    @Test
    void testDeleteEmployee() {
        employeeController.deleteEmployee(Integer.valueOf(0));
    }

    @Test
    void testSettest() {
        employeeController.settest(Integer.valueOf(0), Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme