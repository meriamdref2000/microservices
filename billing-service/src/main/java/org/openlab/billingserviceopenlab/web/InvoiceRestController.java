package org.openlab.billingserviceopenlab.web;


import org.openlab.billingserviceopenlab.dto.InvoiceRequestDTO;
import org.openlab.billingserviceopenlab.dto.InvoiceResponseDTO;
import org.openlab.billingserviceopenlab.entities.Invoice;
import org.openlab.billingserviceopenlab.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoiceById(@PathVariable(name = "id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);

    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable String customerId){
        return invoiceService.allInvoicesByCustomer(customerId);

    }
    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO requestDTO){
        return invoiceService.saveInvoice(requestDTO);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return invoiceService.allInvoices();

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
