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
@Table(name = "TBL_BORROWING_RECORD")
public class BorrowingRecord extends BaseEntity {


    private LocalDate borrowedDate;
    private LocalDate dueDate;
    private LocalDate returnedDate;
    @ManyToOne
    @JoinColumn(name = "book_Id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "member_Id")
    private Member member;
}
