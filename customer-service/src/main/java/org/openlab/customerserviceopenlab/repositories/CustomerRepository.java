package org.openlab.customerserviceopenlab.repositories;

import org.openlab.customerserviceopenlab.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
