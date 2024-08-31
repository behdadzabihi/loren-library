package com.library.loren.service.impl;

import com.library.loren.common.exception.NotFoundException;
import com.library.loren.dao.LibraryRepository;
import com.library.loren.model.Fine;
import com.library.loren.model.Library;
import com.library.loren.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibraryServiceImp implements LibraryService {

    private LibraryRepository libraryRepository;

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library update(Library library) {
        Library updateLibrary=findById(library.getId());
        updateLibrary.setName(library.getName());
        updateLibrary.setAddress(library.getAddress());
        return libraryRepository.save(updateLibrary);
    }

    @Override
    public Library findById(Long id) {
        Optional<Library> libraryOptional = libraryRepository.findById(id);
        if (libraryOptional.isEmpty()) {
            throw new NotFoundException("Fine " + id + "NOT FOUND");
        }
        return libraryOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        libraryRepository.deleteById(id);
    }

    @Override
    public List<Library> findAll() {
        return (List<Library>) libraryRepository.findAll();
    }
}
