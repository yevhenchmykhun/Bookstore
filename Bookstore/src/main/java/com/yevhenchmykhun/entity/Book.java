package com.yevhenchmykhun.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String author;

    @Lob
    private String description;

    private String format;

    private String isbn;

    private String language;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    private int pages;

    private String name;

    private BigDecimal price;

    private String publisher;

    private int quantity;

    @Column(name = "releasedate")
    private Date releaseDate;

    private String cover;

    // bi-directional many-to-one association to Category
    @ManyToOne
    private Category category;

    // bi-directional many-to-one association to OrderedBook
    @OneToMany(mappedBy = "book")
    private List<OrderedBook> orderedBooks;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releasedate) {
        this.releaseDate = releasedate;
    }

    public String getCover() { return cover; }

    public void setCover(String cover) { this.cover = cover; }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<OrderedBook> getOrderedBooks() {
        return this.orderedBooks;
    }

    public void setOrderedBooks(List<OrderedBook> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }

    public OrderedBook addOrderedBook(OrderedBook orderedBook) {
        getOrderedBooks().add(orderedBook);
        orderedBook.setBook(this);

        return orderedBook;
    }

    public OrderedBook removeOrderedBook(OrderedBook orderedBook) {
        getOrderedBooks().remove(orderedBook);
        orderedBook.setBook(null);

        return orderedBook;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Book [id=").append(id).append(", author=")
                .append(author).append(", name=").append(name)
                .append(", quantity=").append(quantity).append("]");
        return builder.toString();
    }

}