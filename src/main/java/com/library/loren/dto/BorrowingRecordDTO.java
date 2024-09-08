package com.library.loren.dto;

import com.library.loren.common.BaseEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
public class BorrowingRecordDTO extends BaseEntity {


    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;

    private BookDTO Book;

    private MemberDTO Member;
}
