package org.example.bookstoresystem.dto.response;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.bookstoresystem.model.AuthorModel;
import org.example.bookstoresystem.model.BookModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Set<AuthorModel> author;
    private String isbn;
    private LocalDate releaseDate;
    private double price;

    public BookResponseDTO(BookModel bookModel){
        this.id = bookModel.getId();
        this.title = bookModel.getTitle();
        this.author = bookModel.getAuthor();
        this.description = bookModel.getDescription();
        this.isbn = bookModel.getIsbn();
        this.releaseDate = bookModel.getReleaseDate();
        this.price = bookModel.getPrice();
    }
}