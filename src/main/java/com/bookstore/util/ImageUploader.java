package com.bookstore.util;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageUploader {

    public String upload(Part part, String coverName, String bookCoversPath) throws IOException {

        String fileName = part.getSubmittedFileName();
        String extention = fileName.substring(fileName.lastIndexOf('.'), fileName.length());

        File uploads = new File(bookCoversPath);

        File file = new File(uploads, coverName + extention);
        try (InputStream input = part.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        return (coverName + extention);

    }

}
