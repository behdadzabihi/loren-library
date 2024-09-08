package com.library.loren.service.impl;

import com.library.loren.common.exception.NotFoundException;
import com.library.loren.dao.BookRepository;
import com.library.loren.model.Book;
import com.library.loren.model.Library;
import com.library.loren.service.BookService;
import com.library.loren.service.LibraryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private LibraryService libraryService;

    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        Long libraryId = book.getLibrary().getId();
        Library library = libraryService.findById(libraryId);
        book.setLibrary(library);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        Book updateBook = findById(book.getId());
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setISBN(book.getISBN());
        updateBook.setPublisher(book.getPublisher());
        updateBook.setGenres(book.getGenres());
        updateBook.setNumberOfCopies(book.getNumberOfCopies());
        updateBook.setAvailableCopies(book.getAvailableCopies());
        Long libraryId = book.getLibrary().getId();
        Library library = libraryService.findById(libraryId);
        updateBook.setLibrary(library);
        return bookRepository.save(updateBook);
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new NotFoundException("Book " + id + "NOT FOUND");
        }
        return bookOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }
}
