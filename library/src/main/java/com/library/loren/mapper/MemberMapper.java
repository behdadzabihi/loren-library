package com.library.loren.mapper;

import com.library.loren.dto.LibraryDTO;
import com.library.loren.dto.MemberDTO;
import com.library.loren.model.Library;
import com.library.loren.model.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toMember(MemberDTO memberDTO);

    MemberDTO toMemberDTO(Member member);

    List<Member> toMembers(List<MemberDTO> memberDTOS);

    List<MemberDTO> toMemberDTOS(List<Member> members);
}