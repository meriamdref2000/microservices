package org.openlab.billingserviceopenlab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceRequestDTO {
    private BigDecimal amount;
    private String customerId;
}
