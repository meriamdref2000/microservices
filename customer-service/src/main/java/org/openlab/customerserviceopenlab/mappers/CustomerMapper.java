package org.openlab.customerserviceopenlab.mappers;
import org.mapstruct.Mapper;
import org.openlab.customerserviceopenlab.dto.RequestDTO;
import org.openlab.customerserviceopenlab.dto.ResponseDTO;
import org.openlab.customerserviceopenlab.entities.Customer;

@Mapper(componentModel =  "spring")
public interface CustomerMapper {

    ResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer customerRequestDTOtoCustomer(RequestDTO customerRequestDTO);
}
