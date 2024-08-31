package com.library.loren.service.impl;

import com.library.loren.model.Librarian;
import com.library.loren.service.LibrarianService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibrarianServiceImpl implements LibrarianService {

    @Override
    public Librarian save(Librarian librarian) {
        return null;
    }

    @Override
    public Librarian update(Librarian librarian) {
        return null;
    }

    @Override
    public Librarian findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Librarian> findAll() {
        return null;
    }
}
