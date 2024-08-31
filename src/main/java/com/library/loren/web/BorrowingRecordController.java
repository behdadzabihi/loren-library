package com.library.loren.web;

import com.library.loren.dto.BorrowingRecordDTO;
import com.library.loren.dto.FineDTO;
import com.library.loren.mapper.BorrowingRecordMapper;
import com.library.loren.mapper.FineMapper;
import com.library.loren.model.BorrowingRecord;
import com.library.loren.model.Fine;
import com.library.loren.service.BorrowingRecordService;
import com.library.loren.service.FineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowing-record")
@AllArgsConstructor
public class BorrowingRecordController {

    private BorrowingRecordService borrowingRecordService;

    private BorrowingRecordMapper borrowingRecordMapper;

    @PostMapping("/create")
    public ResponseEntity<BorrowingRecordDTO> create(@RequestBody BorrowingRecordDTO borrowingRecordDTO) {
        BorrowingRecord borrowingRecord = borrowingRecordMapper.toBorrowingRecord(borrowingRecordDTO);
        borrowingRecordService.save(borrowingRecord);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    public ResponseEntity<BorrowingRecordDTO> update(@RequestBody BorrowingRecordDTO borrowingRecordDTO) {
        BorrowingRecord borrowingRecord = borrowingRecordMapper.toBorrowingRecord(borrowingRecordDTO);
        borrowingRecordService.update(borrowingRecord);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<BorrowingRecordDTO> findById(@PathVariable Long id) {
        BorrowingRecord borrowingRecord = borrowingRecordService.findById(id);
        BorrowingRecordDTO borrowingRecordDTO = borrowingRecordMapper.toBorrowingRecordDTO(borrowingRecord);
        return ResponseEntity.ok(borrowingRecordDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BorrowingRecordDTO>> findAll() {
        List<BorrowingRecord> borrowingRecords = borrowingRecordService.findAll();
        List<BorrowingRecordDTO> borrowingRecordDTOS = borrowingRecordMapper.toBorrowingRecordDTOS(borrowingRecords);
        return ResponseEntity.ok(borrowingRecordDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        borrowingRecordService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
