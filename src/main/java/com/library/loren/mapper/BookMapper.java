package com.library.loren.mapper;

import com.library.loren.dto.BookDTO;
import com.library.loren.model.Book;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = LibraryMapper.class)
public interface BookMapper {

    Book toBook(BookDTO bookDTO);

    BookDTO toBookDTO(Book book);

    List<Book> toBooks(List<BookDTO> bookDTOS);

    List<BookDTO> toBookDTOS(List<Book> books);
}