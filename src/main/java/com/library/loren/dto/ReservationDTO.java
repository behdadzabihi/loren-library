package com.library.loren.dto;

import com.library.loren.common.BaseEntity;
import com.library.loren.model.Book;
import com.library.loren.model.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
public class ReservationDTO extends BaseEntity {


    private BookDTO book;
    private MemberDTO member;
    private LocalDate reservationDate;
    private LocalDate expirationDate;
}
