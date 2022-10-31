package org.openlab.billingserviceopenlab.service;

import org.openlab.billingserviceopenlab.dto.InvoiceRequestDTO;
import org.openlab.billingserviceopenlab.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String id);
    List<InvoiceResponseDTO> allInvoicesByCustomer(String customerID);
    List<InvoiceResponseDTO> allInvoices();


}
