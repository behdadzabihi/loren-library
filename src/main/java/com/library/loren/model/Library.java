package com.library.loren.model;

import com.library.loren.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "TBL_LIBRARY")
public class Library extends BaseEntity {


    private String name;
    private String address;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade = CascadeType.ALL)
    private List<Book> books;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade = CascadeType.ALL)
    private List<Member> members;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade = CascadeType.ALL)
    private List<Librarian> librarians;
}
