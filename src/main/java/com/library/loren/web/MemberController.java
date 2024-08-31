package com.library.loren.web;

import com.library.loren.dto.BookDTO;
import com.library.loren.dto.LibraryDTO;
import com.library.loren.dto.MemberDTO;
import com.library.loren.mapper.LibraryMapper;
import com.library.loren.mapper.MemberMapper;
import com.library.loren.model.Library;
import com.library.loren.model.Member;
import com.library.loren.service.LibraryService;
import com.library.loren.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    private MemberMapper memberMapper;

    @PostMapping("/create")
    public ResponseEntity<MemberDTO> create(@RequestBody MemberDTO memberDTO) {
        Member member = memberMapper.toMember(memberDTO);
        memberService.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    public ResponseEntity<MemberDTO> update(@RequestBody MemberDTO memberDTO) {
        Member member = memberMapper.toMember(memberDTO);
        memberService.update(member);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<MemberDTO> findById(@PathVariable Long id) {
        Member member = memberService.findById(id);
        MemberDTO memberDTO = memberMapper.toMemberDTO(member);
        return ResponseEntity.ok(memberDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MemberDTO>> findAll() {
        List<Member> members = memberService.findAll();
        List<MemberDTO> libraryDTOS = memberMapper.toMemberDTOS(members);
        return ResponseEntity.ok(libraryDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
