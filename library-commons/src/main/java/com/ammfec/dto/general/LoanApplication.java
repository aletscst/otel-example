package com.ammfec.dto.general;

import lombok.Data;

@Data
public class LoanApplication {
    private Integer id;
    private User user;
    private Book book;
    private String status;
    private String creationDate;
    private String updateDate;
}
