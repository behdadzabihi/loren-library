package com.library.loren.web;

import com.library.loren.dto.BookDTO;
import com.library.loren.mapper.BookMapper;
import com.library.loren.model.Book;
import com.library.loren.service.BookService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    private BookMapper bookMapper;

    @PostMapping("/create")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/update")
    public ResponseEntity<BookDTO> update(@RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        bookService.update(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        BookDTO bookDTO = bookMapper.toBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> findAll() {
        List<Book> books = bookService.findAll();
        List<BookDTO> bookDTOS = bookMapper.toBookDTOS(books);
        return ResponseEntity.ok(bookDTOS);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
