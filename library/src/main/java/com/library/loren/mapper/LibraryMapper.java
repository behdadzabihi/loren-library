package com.library.loren.mapper;

import com.library.loren.dto.BookDTO;
import com.library.loren.dto.LibrarianDTO;
import com.library.loren.dto.LibraryDTO;
import com.library.loren.model.Book;
import com.library.loren.model.Library;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryMapper {

    Library toLibrary(LibraryDTO libraryDTO);

    LibraryDTO toLibraryDTO(Library library);

    List<Library> toLibraries(List<LibraryDTO> libraryDTOS);

    List<LibraryDTO> toLibraryDTOS(List<Library> libraries);
}