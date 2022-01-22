package com.example.Salon.Model.Service;
import com.example.Salon.Model.Entities.Services;
import com.example.Salon.Model.Repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    private ServicesRepository servicesRepository ;

    @Autowired
    public ServicesService(ServicesRepository serviceRepository) {
        this.servicesRepository = serviceRepository;
    }

    public List<Services> getService() {
        return servicesRepository.findAll();
    }

    public Optional<Services> getService(Integer serviceId) {
        return servicesRepository.findById(serviceId);
    }

    public void addNewService(Services services ) {
        servicesRepository.save(services);

    }
    public void deleteService(Integer ServicesId) {
        servicesRepository.deleteById(ServicesId);

    }


}
