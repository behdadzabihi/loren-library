package com.library.loren.service.impl;

import com.library.loren.common.exception.NotFoundException;
import com.library.loren.dao.MemberRepository;
import com.library.loren.model.Library;
import com.library.loren.model.Member;
import com.library.loren.service.LibraryService;
import com.library.loren.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    private LibraryService libraryService;

    @Override
    public Member save(Member member) {
        Long libraryId = member.getLibrary().getId();
        Library library = libraryService.findById(libraryId);
        member.setLibrary(library);
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member member) {
        Member updateMember = findById(member.getId());
        updateMember.setName(member.getName());
        updateMember.setEmail(member.getEmail());
        updateMember.setMembershipDate(member.getMembershipDate());
        return memberRepository.save(updateMember);
    }

    @Override
    public Member findById(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);
        if (memberOptional.isEmpty()) {
            throw new NotFoundException("Fine " + id + "NOT FOUND");
        }
        return memberOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        memberRepository.deleteById(id);
    }

    @Override
    public List<Member> findAll() {
        return (List<Member>) memberRepository.findAll();
    }
}
