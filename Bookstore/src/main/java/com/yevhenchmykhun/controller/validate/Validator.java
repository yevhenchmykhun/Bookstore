package com.yevhenchmykhun.controller.validate;


import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Book;

public class Validator {

    public String validateBookQuantity(int bookId, int quantity) {
        Book book = new DaoFactory().getBookDao().getEntityById(bookId);
        if (quantity > book.getQuantity()) {
            return "The required number of books is greater than real";
        }

        return null;
    }

    public String validatePurchase(String name, String email, String phone, String address, String city, String ccNumber) {

        if (name == null
                || name.equals("")
                || name.length() > 45) {
            return buildMessage("name");
        }
        if (email == null
                || email.equals("")
                || !email.contains("@")
                || email.length() > 45) {
            return buildMessage("email");
        }
        if (phone == null
                || phone.equals("")
                || phone.length() < 9) {
            return buildMessage("phone");
        }
        if (address == null
                || address.equals("")
                || address.length() > 45) {
            return buildMessage("address");
        }
        if (city == null
                || city.equals("")
                || city.length() > 45) {
            return buildMessage("city");
        }
        if (ccNumber == null
                || ccNumber.equals("")
                || ccNumber.length() > 16) {
            return buildMessage("ccNumber");
        }

        return null;
    }

    private String buildMessage(String parameter) {
        StringBuilder builder = new StringBuilder();
        builder.append("Parameter \"");
        builder.append(parameter);
        builder.append("\" has an invalid value.");

        return builder.toString();
    }

}
