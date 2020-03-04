package com.yevhenchmykhun.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Card {

    @NotNull
    private String name;

    @NotNull
    @CreditCardNumber(message = "invalid credit card number (Luhn check failed)")
    private String number;

    @NotNull
    @Pattern(regexp = "\\d{2}/\\d{2}")
    private String expiration;

    @NotNull
    @Pattern(regexp = "\\d{3}")
    private String cvv;

}
