package org.openlab.billingserviceopenlab.mappers;


import org.mapstruct.Mapper;
import org.openlab.billingserviceopenlab.dto.InvoiceRequestDTO;
import org.openlab.billingserviceopenlab.dto.InvoiceResponseDTO;
import org.openlab.billingserviceopenlab.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoiceToDTO(Invoice invoice);
}
