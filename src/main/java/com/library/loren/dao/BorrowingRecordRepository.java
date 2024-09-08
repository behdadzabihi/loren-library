package com.library.loren.dao;

import com.library.loren.model.BorrowingRecord;
import org.springframework.data.repository.CrudRepository;

public interface BorrowingRecordRepository extends CrudRepository<BorrowingRecord,Long> {
}
