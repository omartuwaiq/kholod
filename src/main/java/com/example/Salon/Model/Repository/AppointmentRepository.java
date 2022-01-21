package com.example.Salon.Model.Repository;
import com.example.Salon.Model.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
