package com.library.loren.mapper;

import com.library.loren.dto.LibrarianDTO;
import com.library.loren.dto.LibraryDTO;
import com.library.loren.model.Librarian;
import com.library.loren.model.Library;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibrarianMapper {

    Librarian toLibrarian(LibrarianDTO librarianDTO);

    LibrarianDTO toLibrarianDTO(Librarian librarian);

    List<Librarian> toLibrarians(List<LibrarianDTO> librarianDTOS);

    List<LibrarianDTO> toLibrarianDTOS(List<Librarian> librarians);
}