package com.example.Salon.Controller;

import com.example.Salon.Model.Entities.Appointment;
import com.example.Salon.Model.Entities.Employee;
import com.example.Salon.Model.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Salon.Model.Service.AppointmentService ;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAppointments() {
        return appointmentService.getAppointments();
    }


    @GetMapping(path = "{appointmentId}")
    public Optional<Appointment> getAppointment(@PathVariable(name = "appointmentId") Integer appointmentId) {
        return appointmentService.getAppointment(appointmentId) ;
    }

    @PostMapping(path= "add")
    public void registerNewAppointment(@RequestBody Appointment appointment){
        appointmentService.addNewAppointment(appointment);
    }

    @DeleteMapping(path = "delete/{appointmentId}")
    public void deleteAppointment(@PathVariable ("appointmentId") Integer appointmentId){
        appointmentService.deleteAppointment(appointmentId);
    }

}
