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
@Table(name = "TBL_FINE")
public class Fine extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private double amount;
    private LocalDate issueDate;
    private LocalDate paymentDat;
}
