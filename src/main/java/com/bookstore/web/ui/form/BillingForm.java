package com.bookstore.web.ui.form;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class BillingForm {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    @Pattern(regexp = "United States")
    private String country;

    @NotNull
    @Pattern(regexp = "California")
    private String state;

    @NotNull
    @Pattern(regexp = "\\d{5}")
    private String zip;

    private boolean shippingAddressMatchesBillingAddress;

    @NotNull
    private PaymentType paymentType = PaymentType.CREDIT;

    @Valid
    private Card card;

}
