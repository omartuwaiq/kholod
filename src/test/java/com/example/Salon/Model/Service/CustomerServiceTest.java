package com.example.Salon.Model.Service;

import com.example.Salon.Model.Entities.Customers;
import com.example.Salon.Model.Repository.CustomerRepository;
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

class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCustomer() {
        List<Customers> result = customerService.getCustomer();
        Assertions.assertEquals(Arrays.<Customers>asList(new Customers(0, null, null, 0, null, null, null, 0, null, null)), result);
    }

    @Test
    void testGetCustomer2() {
        Optional<Customers> result = customerService.getCustomer(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewCustomer() {
        customerService.addNewCustomer(new Customers(0, null, null, 0, null, null, null, 0, null, null));
    }

    @Test
    void testDeleteCustomer() {
        customerService.deleteCustomer(Integer.valueOf(0));
    }

    @Test
    void testGetCustomerByemail() {
        when(customerRepository.findByEmail(anyString())).thenReturn(null);

        Optional<Customers> result = customerService.getCustomerByemail("email");
        Assertions.assertEquals(null, result);
    }

    @Test
    void testGetCheck() {
        when(customerRepository.findPasswordByEmail(anyString())).thenReturn("findPasswordByEmailResponse");
        when(customerRepository.existsByEmail(anyString())).thenReturn(Boolean.TRUE);

        String result = customerService.getCheck("email", "password");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme