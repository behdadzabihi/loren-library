package com.library.loren.service.impl;

import com.library.loren.common.exception.NotFoundException;
import com.library.loren.dao.BorrowingRecordRepository;
import com.library.loren.model.Book;
import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Member;
import com.library.loren.service.BookService;
import com.library.loren.service.BorrowingRecordService;
import com.library.loren.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BorrowingRecordServiceImp implements BorrowingRecordService {

    private BookService bookService;

    private MemberService memberService;

    private BorrowingRecordRepository borrowingRecordRepository;

    @Override
    public BorrowingRecord save(BorrowingRecord borrowingRecord) {
        Long bookId = borrowingRecord.getBook().getId();
        Book book = bookService.findById(bookId);
        Long memberId = borrowingRecord.getMember().getId();
        Member member = memberService.findById(memberId);
        borrowingRecord.setBook(book);
        borrowingRecord.setMember(member);
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Override
    public BorrowingRecord update(BorrowingRecord borrowingRecord) {
        BorrowingRecord updateBorrowingRecord = findById(borrowingRecord.getId());
        updateBorrowingRecord.setBorrowedDate(borrowingRecord.getBorrowedDate());
        updateBorrowingRecord.setDueDate(borrowingRecord.getDueDate());
        updateBorrowingRecord.setReturnedDate(borrowingRecord.getReturnedDate());
        Long bookId = borrowingRecord.getBook().getId();
        Book book = bookService.findById(bookId);
        Long memberId = borrowingRecord.getMember().getId();
        Member member = memberService.findById(memberId);
        updateBorrowingRecord.setBook(book);
        updateBorrowingRecord.setMember(member);
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Override
    public BorrowingRecord findById(Long id) {
        Optional<BorrowingRecord> borrowingRecordOptional = borrowingRecordRepository.findById(id);
        if (borrowingRecordOptional.isEmpty()) {
            throw new NotFoundException("Borrowing Record " + id + "NOT FOUND");
        }
        return borrowingRecordOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        borrowingRecordRepository.deleteById(id);
    }

    @Override
    public List<BorrowingRecord> findAll() {
        return (List<BorrowingRecord>) borrowingRecordRepository.findAll();
    }
}
