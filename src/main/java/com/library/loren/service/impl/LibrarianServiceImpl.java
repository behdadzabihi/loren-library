package com.library.loren.service.impl;

import com.library.loren.common.exception.NotFoundException;
import com.library.loren.dao.LibrarianRepository;
import com.library.loren.model.Librarian;
import com.library.loren.model.Library;
import com.library.loren.service.LibrarianService;
import com.library.loren.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {

    private LibraryService libraryService;

    private LibrarianRepository librarianRepository;
    @Override
    public Librarian save(Librarian librarian) {
        Long libraryId = librarian.getLibrary().getId();
        Library library = libraryService.findById(libraryId);
        librarian.setLibrary(library);
        return librarianRepository.save(librarian);
    }

    @Override
    public Librarian update(Librarian librarian) {
        Librarian updateLibrarian = findById(librarian.getId());
        updateLibrarian.setName(librarian.getName());
        updateLibrarian.setEmail(librarian.getEmail());
        updateLibrarian.setHireDate(librarian.getHireDate());
        Long libraryId = librarian.getLibrary().getId();
        Library library = libraryService.findById(libraryId);
        updateLibrarian.setLibrary(library);
        return librarianRepository.save(updateLibrarian);
    }

    @Override
    public Librarian findById(Long id) {
        Optional<Librarian> optionalLibrarian=librarianRepository.findById(id);
        if(optionalLibrarian.isEmpty()){
            throw new NotFoundException("Librarian " + id + " NOT FOUND");
        }
        return optionalLibrarian.get();
    }

    @Override
    public void deleteById(Long id) {
    findById(id);
    librarianRepository.deleteById(id);
    }

    @Override
    public List<Librarian> findAll() {
        return (List<Librarian>) librarianRepository.findAll();
    }
}
