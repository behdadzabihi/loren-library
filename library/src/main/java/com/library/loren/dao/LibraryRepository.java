package com.library.loren.dao;

import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library,Long> {
}
