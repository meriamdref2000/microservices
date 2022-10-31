package org.openlab.billingserviceopenlab.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String email;
}
