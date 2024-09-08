package com.library.loren.web;

import com.library.loren.dto.BookDTO;
import com.library.loren.dto.LibraryDTO;
import com.library.loren.mapper.BookMapper;
import com.library.loren.mapper.LibraryMapper;
import com.library.loren.model.Book;
import com.library.loren.model.Library;
import com.library.loren.service.BookService;
import com.library.loren.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@AllArgsConstructor
public class LibraryController {

    private LibraryService libraryService;

    private LibraryMapper libraryMapper;

    @PostMapping("/create")
    public ResponseEntity<LibraryDTO> create(@RequestBody LibraryDTO libraryDTO) {
        Library library = libraryMapper.toLibrary(libraryDTO);
        libraryService.save(library);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    public ResponseEntity<BookDTO> update(@RequestBody LibraryDTO libraryDTO) {
        Library library = libraryMapper.toLibrary(libraryDTO);
        libraryService.update(library);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<LibraryDTO> findById(@PathVariable Long id) {
        Library library = libraryService.findById(id);
        LibraryDTO libraryDTO = libraryMapper.toLibraryDTO(library);
        return ResponseEntity.ok(libraryDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LibraryDTO>> findAll() {
        List<Library> libraries = libraryService.findAll();
        List<LibraryDTO> libraryDTOS = libraryMapper.toLibraryDTOS(libraries);
        return ResponseEntity.ok(libraryDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libraryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
