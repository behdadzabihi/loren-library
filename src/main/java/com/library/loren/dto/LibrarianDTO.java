package com.library.loren.dto;

import com.library.loren.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
public class LibrarianDTO extends BaseEntity {


    private String name;
    private String email;
    private LocalDate hireDate;
    private LibraryDTO library;
}
