package com.library.loren.dao;

import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Fine;
import org.springframework.data.repository.CrudRepository;

public interface FineRepository extends CrudRepository<Fine,Long> {
}
