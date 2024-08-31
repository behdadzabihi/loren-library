package com.library.loren.mapper;

import com.library.loren.dto.FineDTO;
import com.library.loren.dto.LibraryDTO;
import com.library.loren.model.Fine;
import com.library.loren.model.Library;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = MemberMapper.class)
public interface FineMapper {

    Fine toFine(FineDTO fineDTO);

    FineDTO toFineDTO(Fine fine);

    List<Fine> toFines(List<FineDTO> fineDTOS);

    List<FineDTO> toFineDTOS(List<Fine> fines);
}