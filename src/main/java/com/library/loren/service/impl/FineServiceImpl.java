package com.library.loren.service.impl;

import com.library.loren.common.exception.NotFoundException;
import com.library.loren.dao.FineRepository;
import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Fine;
import com.library.loren.model.Member;
import com.library.loren.service.FineService;
import com.library.loren.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FineServiceImpl implements FineService {

    private MemberService memberService;

    private FineRepository fineRepository;

    @Override
    public Fine save(Fine fine) {
        Long memberId = fine.getMember().getId();
        Member member = memberService.findById(memberId);
        fine.setMember(member);
        return fineRepository.save(fine);
    }

    @Override
    public Fine update(Fine fine) {
        Fine updateFine = findById(fine.getId());
        updateFine.setAmount(fine.getAmount());
        updateFine.setIssueDate(fine.getIssueDate());
        updateFine.setPaymentDat(fine.getPaymentDat());
        Long memberId = fine.getMember().getId();
        Member member = memberService.findById(memberId);
        updateFine.setMember(member);
        return fineRepository.save(updateFine);
    }

    @Override
    public Fine findById(Long id) {
        Optional<Fine> fineOptional = fineRepository.findById(id);
        if (fineOptional.isEmpty()) {
            throw new NotFoundException("Fine " + id + "NOT FOUND");
        }
        return fineOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        fineRepository.deleteById(id);
    }

    @Override
    public List<Fine> findAll() {
        return (List<Fine>) fineRepository.findAll();
    }
}
