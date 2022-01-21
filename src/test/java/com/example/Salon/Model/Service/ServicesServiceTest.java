package com.example.Salon.Model.Service;

import com.example.Salon.Model.Entities.Services;
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

class ServicesServiceTest {
    @Mock
    ServicesRepository servicesRepository;
    @InjectMocks
    ServicesService servicesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetService() {
        List<Services> result = servicesService.getService();
        Assertions.assertEquals(Arrays.<Services>asList(new Services(0, "sname", 0d, "materials", "photo")), result);
    }

    @Test
    void testGetService2() {
        Optional<Services> result = servicesService.getService(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewService() {
        servicesService.addNewService(new Services(0, "sname", 0d, "materials", "photo"));
    }

    @Test
    void testDeleteService() {
        servicesService.deleteService(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme