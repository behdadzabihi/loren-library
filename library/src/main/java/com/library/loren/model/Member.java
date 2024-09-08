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
@Table(name = "TBL_MEMBER")
public class Member extends BaseEntity {

    private String name;
    private String email;
    private LocalDate membershipDate;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
    private List<BorrowingRecord> borrowingHistory;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
    private List<Fine> fines;
    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;


}
