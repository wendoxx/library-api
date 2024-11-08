package org.example.bookstoresystem.service;

import jakarta.transaction.Transactional;
import org.example.bookstoresystem.dto.request.AuthorRequestDTO;
import org.example.bookstoresystem.dto.response.AuthorResponseDTO;
import org.example.bookstoresystem.model.AuthorModel;
import org.example.bookstoresystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public AuthorModel saveAndUpdateAuthor(AuthorRequestDTO authorRequestDTO){
        AuthorModel author;

        if (authorRequestDTO.getId() != null && authorRepository.existsById(authorRequestDTO.getId())){
            author = authorRepository.findById(authorRequestDTO.getId()).get();
        }else {
            author = new AuthorModel();
        }

        author.setId(authorRequestDTO.getId());
        author.setName(authorRequestDTO.getName());

        return authorRepository.save(author);
    }

    public AuthorResponseDTO getAuthorById(Long id){
        return authorRepository.findById(id)
                .map(AuthorResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Author not found."));
    }

    public AuthorResponseDTO getAuthorByName(String name){
        return authorRepository.findByName(name)
                .map(AuthorResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<AuthorResponseDTO> getAllAuthors(){
        return authorRepository.findAll().stream().map(AuthorResponseDTO::new).toList();
    }

    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

}
