package com.library.loren.web;

import com.library.loren.dto.LibrarianDTO;
import com.library.loren.dto.LibraryDTO;
import com.library.loren.dto.MemberDTO;
import com.library.loren.mapper.LibrarianMapper;
import com.library.loren.mapper.MemberMapper;
import com.library.loren.model.Librarian;
import com.library.loren.model.Member;
import com.library.loren.service.LibrarianService;
import com.library.loren.service.LibraryService;
import com.library.loren.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarian")
@AllArgsConstructor
public class LibrarianController {

    private LibrarianService librarianService;

    private LibrarianMapper librarianMapper;

    @PostMapping("/create")
    public ResponseEntity<LibrarianDTO> create(@RequestBody LibrarianDTO librarianDTO) {
        Librarian librarian = librarianMapper.toLibrarian(librarianDTO);
        librarianService.save(librarian);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    public ResponseEntity<MemberDTO> update(@RequestBody LibrarianDTO librarianDTO) {
        Librarian librarian = librarianMapper.toLibrarian(librarianDTO);
        librarianService.update(librarian);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<LibrarianDTO> findById(@PathVariable Long id) {
        Librarian librarian = librarianService.findById(id);
        LibrarianDTO librarianDTO = librarianMapper.toLibrarianDTO(librarian);
        return ResponseEntity.ok(librarianDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LibrarianDTO>> findAll() {
        List<Librarian> librarians = librarianService.findAll();
        List<LibrarianDTO> LibrarianDTOS = librarianMapper.toLibrarianDTOS(librarians);
        return ResponseEntity.ok(LibrarianDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        librarianService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
