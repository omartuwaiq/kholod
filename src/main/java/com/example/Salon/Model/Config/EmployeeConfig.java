package com.example.Salon.Model.Config;
import com.example.Salon.Model.Entities.Employee;
import com.example.Salon.Model.Entities.Services;
import com.example.Salon.Model.Repository.EmployeeRepository;

import com.example.Salon.Model.Repository.ServicesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner3 (EmployeeRepository repository){
        return args -> {

            Employee rrr=new Employee(
                    15,
                    "mehdi",
                    "mehdi",
                    "mehdi@gmail.com",
                    "mehdi"

            );


            repository.save(rrr);

            Employee aaa=new Employee(
                    160,
                    "kholod",
                    "kholod",
                    "kholod@gmail.com",
                    "kholod"

            );


            repository.save(aaa);

        };
    }
}
