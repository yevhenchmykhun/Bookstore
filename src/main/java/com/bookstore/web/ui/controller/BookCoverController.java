package com.bookstore.web.ui.controller;

import com.bookstore.service.BookCoverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequiredArgsConstructor
class BookCoverController {

    private final BookCoverService bookCoverService;

    @GetMapping("/book-cover/{coverId}")
    @ResponseBody
    public ResponseEntity<byte[]> getBookCover(@PathVariable Long coverId) {
        return bookCoverService.findById(coverId)
                .map(cover ->
                        ResponseEntity
                                .ok()
                                .contentType(MediaType.IMAGE_JPEG)
                                .cacheControl(CacheControl.maxAge(1, TimeUnit.DAYS))
                                .body(cover.getBytes()))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

}
