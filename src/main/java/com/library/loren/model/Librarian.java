package com.library.loren.model;

import com.library.loren.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "TBL_LIBRARIAN")
public class Librarian extends BaseEntity {


    private String name;
    private String email;
    private LocalDate hireDate;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
}
