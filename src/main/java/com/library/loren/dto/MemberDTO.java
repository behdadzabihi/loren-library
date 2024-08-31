package com.library.loren.dto;

import com.library.loren.common.BaseEntity;
import com.library.loren.model.BorrowingRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
public class MemberDTO extends BaseEntity {

    private String name;
    private String email;
    private LocalDate membershipDate;
}
