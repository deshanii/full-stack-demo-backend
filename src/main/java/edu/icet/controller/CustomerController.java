package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
//@CrossOrigin
/*//http://localhost:4200/*/

public class CustomerController {
    @Autowired
    final CustomerService service;

    @GetMapping("/get-customer")
    public List<Customer> getCustomer() {
        return service.getAll();

    }

    @PostMapping("/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        service.addCustomer(customer);

    }

    @GetMapping("/search-by-id/{Id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return service.searchCustomerById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomerById(@PathVariable Integer id){
        service.deleteCustomerById(id);

    }

    @PutMapping("/update-customer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomerById(customer);
    }
}




