package com.example.Salon.Model.Service;

import com.example.Salon.Model.Entities.Appointment;
import com.example.Salon.Model.Repository.AppointmentRepository;
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

class AppointmentServiceTest {
    @Mock
    AppointmentRepository appointmentRepository;
    @InjectMocks
    AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAppointments() {
        List<Appointment> result = appointmentService.getAppointments();
        Assertions.assertEquals(Arrays.<Appointment>asList(new Appointment(0, null, null, 0, null, null, null)), result);
    }

    @Test
    void testGetAppointment() {
        Optional<Appointment> result = appointmentService.getAppointment(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testAddNewAppointment() {
        appointmentService.addNewAppointment(new Appointment(0, null, null, 0, null, null, null));
    }

    @Test
    void testDeleteAppointment() {
        appointmentService.deleteAppointment(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme