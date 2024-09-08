package com.library.loren.dto;

import com.library.loren.common.BaseEntity;
import com.library.loren.model.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
public class FineDTO extends BaseEntity {


    private MemberDTO member;
    private double amount;
    private LocalDate issueDate;
    private LocalDate paymentDat;
}
