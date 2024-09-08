package com.library.loren.mapper;

import com.library.loren.dto.BorrowingRecordDTO;
import com.library.loren.dto.LibraryDTO;
import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Library;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BookMapper.class, MemberMapper.class})
public interface BorrowingRecordMapper {

    BorrowingRecord toBorrowingRecord(BorrowingRecordDTO borrowingRecordDTO);

    BorrowingRecordDTO toBorrowingRecordDTO(BorrowingRecord borrowingRecord);

    List<BorrowingRecord> toBorrowingRecords(List<BorrowingRecordDTO> borrowingRecordDTOS);

    List<BorrowingRecordDTO> toBorrowingRecordDTOS(List<BorrowingRecord> borrowingRecords);
}