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
        return repository.findById(id).map(bookMapper::toBook);
    }

    public List<Book> findBySearchPhrase(String phrase) {
        return repository.findBySearchPhrase(phrase).stream()
                .map(bookMapper::toBook)
                .collect(Collectors.toList());
    }

    public List<Book> findAllByCategoryId(Long categoryId, Pageable pageable) {
        return repository.findAllByCategoryId(categoryId, pageable).stream()
                .map(bookMapper::toBook)
                .collect(Collectors.toList());
    }

    public List<Book> findAll() {
        return repository.findAll().stream()
                .map(bookMapper::toBook)
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
        BookEntity entity = bookMapper.toBookEntity(bookForm);
        entity.setS3CoverKey(key);
        repository.saveAndFlush(entity);
    }

    public Book save(Book book) {
        BookEntity bookEntity = bookMapper.toBookEntity(book);
        return bookMapper.toBook(bookEntity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
