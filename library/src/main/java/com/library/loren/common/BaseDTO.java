package com.library.loren.common;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BaseDTO {


    private Long id;


    private Integer version;


    private LocalDate createdData;

    private String createdBy;


    private LocalDate lastModifiedData;


    private String lastModifiedBy;
}
