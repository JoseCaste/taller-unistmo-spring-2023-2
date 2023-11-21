package com.unistmo.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ProductDTO {

    private String productName;
    private Date createdDate;
    private String staticMessage;
}
