package org.openlab.billingserviceopenlab.repositories;

import org.openlab.billingserviceopenlab.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String customerId);
}
