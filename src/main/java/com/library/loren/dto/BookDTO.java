package com.library.loren.dto;

import com.library.loren.common.BaseDTO;
import com.library.loren.common.BaseEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookDTO extends BaseDTO {

    String title;
    String author;
    String ISBN;
    String publisher;
    LocalDate publicationDate;
    List<String> genres;
    int numberOfCopies;
    int availableCopies;

}
