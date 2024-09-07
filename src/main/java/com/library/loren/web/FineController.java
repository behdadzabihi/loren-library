package com.library.loren.web;

import com.library.loren.dto.BookDTO;
import com.library.loren.dto.FineDTO;
import com.library.loren.mapper.BookMapper;
import com.library.loren.mapper.FineMapper;
import com.library.loren.model.Book;
import com.library.loren.model.Fine;
import com.library.loren.service.BookService;
import com.library.loren.service.FineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fine")
@AllArgsConstructor
public class FineController {

    private FineService fineService;

    private FineMapper fineMapper;

    @PostMapping("/create")
    public ResponseEntity<FineDTO> create(@RequestBody FineDTO fineDTO) {
        Fine fine = fineMapper.toFine(fineDTO);
        fineService.save(fine);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    public ResponseEntity<FineDTO> update(@RequestBody FineDTO fineDTO) {
        Fine fine = fineMapper.toFine(fineDTO);
        fineService.update(fine);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<FineDTO> findById(@PathVariable Long id) {
        Fine fine = fineService.findById(id);
        FineDTO fineDTO = fineMapper.toFineDTO(fine);
        return ResponseEntity.ok(fineDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FineDTO>> findAll() {
        List<Fine> fines = fineService.findAll();
        List<FineDTO> fineDTOS = fineMapper.toFineDTOS(fines);
        return ResponseEntity.ok(fineDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fineService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
