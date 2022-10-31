package org.openlab.customerserviceopenlab.service;

import org.openlab.customerserviceopenlab.dto.RequestDTO;
import org.openlab.customerserviceopenlab.dto.ResponseDTO;
import org.openlab.customerserviceopenlab.entities.Customer;
import org.openlab.customerserviceopenlab.mappers.CustomerMapper;
import org.openlab.customerserviceopenlab.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public ResponseDTO saveCustomer(RequestDTO requestDTO) {
        /*
            Mapping Objet Objet
         */
        //Customer customer =new Customer();
        //customer.setId(requestDTO.getId());
        //customer.setEmail(requestDTO.getEmail());
        //customer.setName(requestDTO.getName());
       // customer.setId(UUID.randomUUID().toString());

        Customer customer = customerMapper.customerRequestDTOtoCustomer(requestDTO);

        Customer savedCustomer = customerRepository.save(customer);
        //System.out.println(savedCustomer.getId()+"");

        /*
            Mapping objet objet
         */
        //ResponseDTO customerResponse = new ResponseDTO();
        //customerResponse.setId(savedCustomer.getId());
        //customerResponse.setName(savedCustomer.getName());
        //customerResponse.setEmail(savedCustomer.getEmail());
        ResponseDTO customerResponse = customerMapper.customerToCustomerResponseDTO(savedCustomer);


        return customerResponse;
    }

    @Override
    public ResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponseDTO(customer);
    }

    @Override
    public ResponseDTO updateCustomer(RequestDTO cutomerRequestDto) {
        Customer customer = customerMapper.customerRequestDTOtoCustomer(cutomerRequestDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDTO(savedCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<ResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<ResponseDTO> responseDTOS =
                customers.stream()
                        .map(
                        customer -> customerMapper.customerToCustomerResponseDTO(customer))
                .collect(Collectors.toList());
        return responseDTOS;
    }
}
