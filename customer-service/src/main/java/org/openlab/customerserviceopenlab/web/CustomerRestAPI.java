package org.openlab.customerserviceopenlab.web;
import org.openlab.customerserviceopenlab.dto.RequestDTO;
import org.openlab.customerserviceopenlab.dto.ResponseDTO;
import org.openlab.customerserviceopenlab.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<ResponseDTO> getAllCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping(path = "/customers")
    public ResponseDTO addCustomer(@RequestBody RequestDTO requestDTO){
        requestDTO.setId(UUID.randomUUID().toString());
        return customerService.saveCustomer(requestDTO);
    }

    @GetMapping(path = "/customers/{id}")
    public ResponseDTO getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }
}
