package com.library.loren.dao;

import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Long> {
}
