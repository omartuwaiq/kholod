package com.example.Salon.Controller;

import com.example.Salon.Model.Entities.Appointment;
import com.example.Salon.Model.Service.AppointmentService;
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

class AppointmentControllerTest {
    @Mock
    AppointmentService appointmentService;
    @InjectMocks
    AppointmentController appointmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAppointments() {
        when(appointmentService.getAppointments()).thenReturn(Arrays.<Appointment>asList(new Appointment(0, null, null, 0, null, null, null)));

        List<Appointment> result = appointmentController.getAppointments();
        Assertions.assertEquals(Arrays.<Appointment>asList(new Appointment(0, null, null, 0, null, null, null)), result);
    }

    @Test
    void testGetAppointment() {
        when(appointmentService.getAppointment(anyInt())).thenReturn(null);

        Optional<Appointment> result = appointmentController.getAppointment(Integer.valueOf(0));
        Assertions.assertEquals(null, result);
    }

    @Test
    void testRegisterNewAppointment() {
        appointmentController.registerNewAppointment(new Appointment(0, null, null, 0, null, null, null));
    }

    @Test
    void testDeleteAppointment() {
        appointmentController.deleteAppointment(Integer.valueOf(0));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme