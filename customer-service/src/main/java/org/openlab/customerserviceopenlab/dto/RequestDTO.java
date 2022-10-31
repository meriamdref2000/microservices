package org.openlab.customerserviceopenlab.dto;
import lombok.Data;

@Data
public class RequestDTO {
    private String id;
    private String name;
    private String email;

    public RequestDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public RequestDTO() {
    }
}
