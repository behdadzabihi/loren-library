package com.library.loren.dto;

import com.library.loren.common.BaseEntity;
import com.library.loren.model.Book;
import com.library.loren.model.Librarian;
import com.library.loren.model.Member;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class LibraryDTO extends BaseEntity {


    private String name;
    private String address;
}
