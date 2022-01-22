package com.example.Salon.Controller;
import com.example.Salon.Model.Entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
    private com.example.Salon.Model.Service.CustomerService customerService;
    @Autowired
    public CustomerController(com.example.Salon.Model.Service.CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customers> getCustomer() {
        return customerService.getCustomer();
    }

    @GetMapping(path = "{customerId}")
    public Optional<Customers> getcustomer(@PathVariable(name = "customerId") Integer customerId) {
        return customerService.getCustomer(customerId);
    }

    @GetMapping(path = "/getCustomerbyemail/{email}")
    public Optional<Customers> getCustomer(@PathVariable("email") String email) {
        return customerService.getCustomerByemail(email) ;
    }

    @PostMapping(path= "add")
    public void registerNewEmployee(@RequestBody Customers customers){
        customerService.addNewCustomer(customers);
    }
    @DeleteMapping(path = "delete/{customerId}")
    public void deletecustomer(@PathVariable ("customerId") Integer customerId){
        customerService.deleteCustomer(customerId);
    }
    @GetMapping(path = "login")
    public String checkLogin(@RequestParam (name = "email") String email ,
                             @RequestParam (name = "password") String password ) {
        return customerService.getCheck(email,password);
    }
}