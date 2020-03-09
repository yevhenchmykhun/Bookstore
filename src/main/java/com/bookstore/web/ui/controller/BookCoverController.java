package com.bookstore.web.ui.controller;

import com.bookstore.model.dto.BookCover;
import com.bookstore.service.BookCoverService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class BookCoverController {

    private BookCoverService bookCoverService;

    public BookCoverController(BookCoverService bookCoverService) {
        this.bookCoverService = bookCoverService;
    }

    @GetMapping("/book-cover/{coverId}")
    @ResponseBody
    public ResponseEntity<Resource> getBookCoverAsResource(@PathVariable Long coverId) {
        Optional<BookCover> bookCover = bookCoverService.findById(coverId);
        if (bookCover.isPresent()) {
            ByteArrayResource resource = new ByteArrayResource(bookCover.get().getBytes());
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
