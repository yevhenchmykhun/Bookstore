package com.bookstore.properties;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Component("s3Properties")
@ConfigurationProperties("aws.s3")
@Validated
@Data
public class S3Properties {

    @NotBlank
    private String bucketName;

    @NotBlank
    @URL(regexp = ".*/$") // URL which ends with '/'
    private String bucketUrl;

}


