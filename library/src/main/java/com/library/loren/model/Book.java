package com.library.loren.model;

import com.library.loren.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "TBL_BOOK")
public class Book extends BaseEntity {

    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private LocalDate publicationDate;
    private List<String> genres;
    private int numberOfCopies;
    private int availableCopies;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
    private List<BorrowingRecord> reservations;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

}
