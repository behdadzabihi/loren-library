package com.library.loren.dto;

import com.library.loren.common.BaseDTO;
import com.library.loren.common.BaseEntity;
import com.library.loren.model.Library;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookDTO extends BaseDTO {

    private String title;
    private String author;
    private String ISBN;
    private String publisher;
    private LocalDate publicationDate;
    private List<String> genres;
    private int numberOfCopies;
    private int availableCopies;
    private LibraryDTO library;

}
