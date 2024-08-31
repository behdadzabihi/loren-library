package com.library.loren.dao;

import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Librarian;
import org.springframework.data.repository.CrudRepository;

public interface LibrarianRepository extends CrudRepository<Librarian,Long> {
}
