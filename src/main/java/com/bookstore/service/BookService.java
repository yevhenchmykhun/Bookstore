package com.bookstore.service;

import com.bookstore.model.dto.Book;
import com.bookstore.model.entity.BookEntity;
import com.bookstore.model.mapping.BookMapper;
import com.bookstore.repository.BookRepository;
import com.bookstore.web.ui.form.BookForm;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    private final BookMapper bookMapper;

    private final BookCoverService bookCoverService;

    public Optional<Book> findById(Long id) {
        Optional<BookEntity> bookEntity = repository.findById(id);
        return bookEntity.map(bookMapper::bookEntityToBook);
    }

    public List<Book> findByNameContaining(String title) {
        return repository.findByTitleContaining(title).stream()
                .map(bookMapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    public List<Book> findByAuthorContaining(String author) {
        return repository.findByAuthorContaining(author).stream()
                .map(bookMapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    public List<Book> findByIsbnContaining(String isbn) {
        return repository.findByIsbnContaining(isbn).stream()
                .map(bookMapper::bookEntityToBook)
                .collect(Collectors.toList());
    }


    public List<Book> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return repository.findAllByCategoryId(categoryId, pageable).stream()
                .map(bookMapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    public List<Book> findAll() {
        return repository.findAll().stream()
                .map(bookMapper::bookEntityToBook)
                .collect(Collectors.toList());
    }

    public Long countByCategoryId(Long categoryId) {
        return repository.countByCategoryId(categoryId);
    }

    @SneakyThrows
    public void save(BookForm bookForm) {

        // upload book cover to S3
        byte[] bytes = bookForm.getCover().getBytes();
        String contentType = bookForm.getCover().getContentType();
        String key = bookCoverService.upload(bytes, contentType);

        // save book to local DB
        BookEntity entity = bookMapper.bookFormToBookEntity(bookForm);
        entity.setS3CoverKey(key);
        repository.saveAndFlush(entity);
    }

    public Book save(Book book) {
        BookEntity bookEntity = bookMapper.bookToBookEntity(book);
        return bookMapper.bookEntityToBook(bookEntity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
