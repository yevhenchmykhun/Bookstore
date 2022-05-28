package com.bookstore.service;

import com.bookstore.properties.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookCoverService {

    private final S3Properties s3Properties;

    private final S3Client s3Client;

    public String upload(byte[] bytes, String contentType) {

        String key = "cover/" + UUID.randomUUID();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(s3Properties.getBucketName())
                .contentType(contentType)
                .key(key)
                .build();

        s3Client.putObject(request, RequestBody.fromBytes(bytes));

        return key;
    }

}
