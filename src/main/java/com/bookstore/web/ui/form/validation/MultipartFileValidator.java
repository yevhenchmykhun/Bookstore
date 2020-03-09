package com.bookstore.web.ui.form.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultipartFileValidator implements ConstraintValidator<File, MultipartFile> {

    private String mediaType;
    private long size;

    public void initialize(File file) {
        this.mediaType = file.mediaType();
        this.size = file.size();
    }

    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null) {
            return true;
        }

        if (file.isEmpty()) {
            return false;
        }

        return mediaType.equals(file.getContentType()) && size >= file.getSize();
    }
}
