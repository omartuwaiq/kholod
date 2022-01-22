package com.example.Salon.Controller;

import com.example.Salon.Model.Entities.Customers;
import com.example.Salon.Model.Service.CustomerService;
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

class CustomerControllerTest {
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCustomer() {
        when(customerService.getCustomer()).thenReturn(Arrays.<Customers>asList(new Customers(0, null, null, 0, null, null, null, 0, null, null)));

        List<Customers> result = customerController.getCustomer();
        Assertions.assertEquals(Arrays.<Customers>asList(new Customers(0, null, null, 0, null, null, null, 0, null, null)), result);
    }

    @Test
    void testGetcustomer() {
        when(customerService.getCustomer(anyInt())).thenReturn(null);

        Optional<Customers> result = customerController.getcustomer(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetCustomer2() {
        when(customerService.getCustomerByemail(anyString())).thenReturn(null);

        Optional<Customers> result = customerController.getCustomer("email");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewEmployee() {
        customerController.registerNewEmployee(new Customers(0, null, null, 0, null, null, null, 0, null, null));
    }

    @Test
    void testDeletecustomer() {
        customerController.deletecustomer(Integer.valueOf(0));
    }

    @Test
    void testCheckLogin() {
        when(customerService.getCheck(anyString(), anyString())).thenReturn("getCheckResponse");

        String result = customerController.checkLogin("email", "password");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme