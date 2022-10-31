package org.openlab.billingserviceopenlab.service;

import org.openlab.billingserviceopenlab.dto.InvoiceRequestDTO;
import org.openlab.billingserviceopenlab.dto.InvoiceResponseDTO;
import org.openlab.billingserviceopenlab.entities.Customer;
import org.openlab.billingserviceopenlab.entities.Invoice;
import org.openlab.billingserviceopenlab.exceptions.CustomerNotFoundException;
import org.openlab.billingserviceopenlab.mappers.InvoiceMapper;
import org.openlab.billingserviceopenlab.openfeign.CustomerRestClient;
import org.openlab.billingserviceopenlab.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoiceRequestDTO) {
        Customer customer = null;
        try {
            customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Customer not found!!");
        }
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);

        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        Invoice savedInvoice = invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customer);
        InvoiceResponseDTO invoiceResponseDTO = invoiceMapper.fromInvoiceToDTO(savedInvoice);

        return invoiceResponseDTO;
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {

        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        InvoiceResponseDTO invoiceResponseDTO = invoiceMapper.fromInvoiceToDTO(invoice);

        return invoiceResponseDTO;
    }

    @Override
    public List<InvoiceResponseDTO> allInvoicesByCustomer(String customerID) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerID);
        for (Invoice invoice:invoices){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }

        return invoices
                .stream()
                .map(invoice -> invoiceMapper.fromInvoiceToDTO(invoice))
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice:invoices){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoiceToDTO(invoice)).collect(Collectors.toList());
    }
}
