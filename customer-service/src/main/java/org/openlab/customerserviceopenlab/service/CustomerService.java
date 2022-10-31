package org.openlab.customerserviceopenlab.service;


import org.openlab.customerserviceopenlab.dto.RequestDTO;
import org.openlab.customerserviceopenlab.dto.ResponseDTO;

import java.util.List;

public interface CustomerService {
    ResponseDTO saveCustomer(RequestDTO requestDTO);
    ResponseDTO getCustomer(String id);
    ResponseDTO updateCustomer(RequestDTO cutomerRequestDto);
    void deleteCustomer(String id);
    List<ResponseDTO> listCustomers();

}
