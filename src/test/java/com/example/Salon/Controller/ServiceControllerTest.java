package com.example.Salon.Controller;

import com.example.Salon.Model.Entities.Services;
import com.example.Salon.Model.Service.ServicesService;
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

class ServiceControllerTest {
    @Mock
    ServicesService servicesService;
    @InjectMocks
    ServiceController serviceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetService() {
        when(servicesService.getService()).thenReturn(Arrays.<Services>asList(new Services(0, "sname", 0d, "materials", "photo")));

        List<Services> result = serviceController.getService();
        Assertions.assertEquals(Arrays.<Services>asList(new Services(0, "sname", 0d, "materials", "photo")), result);
    }

    @Test
    void testGetService2() {
        when(servicesService.getService(anyInt())).thenReturn(null);

        Optional<Services> result = serviceController.getService(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterService() {
        serviceController.registerService(new Services(0, "sname", 0d, "materials", "photo"));
    }

    @Test
    void testDeleteservice() {
        serviceController.deleteservice(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme