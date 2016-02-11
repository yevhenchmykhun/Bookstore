DROP SCHEMA IF EXISTS bookstore;
CREATE SCHEMA IF NOT EXISTS bookstore
  DEFAULT CHARACTER SET 'utf8';
USE bookstore;


DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name        VARCHAR(45)  NOT NULL,
  email       VARCHAR(45)  NOT NULL,
  phone       VARCHAR(45)  NOT NULL,
  address     VARCHAR(45)  NOT NULL,
  city_region VARCHAR(45)   NOT NULL,
  cc_number   VARCHAR(16)  NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  COMMENT = 'maintains customer details';


DROP TABLE IF EXISTS customer_order;

CREATE TABLE IF NOT EXISTS customer_order (
  id                  INT UNSIGNED  NOT NULL AUTO_INCREMENT,
  amount              DECIMAL(6, 2) NOT NULL,
  date_created        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  confirmation_number INT UNSIGNED  NOT NULL,
  customer_id         INT UNSIGNED  NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_customer_order_customer (customer_id ASC),
  CONSTRAINT fk_customer_order_customer
  FOREIGN KEY (customer_id)
  REFERENCES customer (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  COMMENT = 'maintains customer order details';


DROP TABLE IF EXISTS category;

CREATE TABLE IF NOT EXISTS category (
  id   TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45)      NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  COMMENT = 'contains books categories';


DROP TABLE IF EXISTS book;

CREATE TABLE IF NOT EXISTS book (
  id          INT UNSIGNED      NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255)      NOT NULL,
  price       DECIMAL(5, 2)     NOT NULL,
  format      VARCHAR(45)       NOT NULL,
  language    VARCHAR(45)       NOT NULL,
  isbn        VARCHAR(45)       NOT NULL,
  releasedate DATE              NOT NULL,
  author      VARCHAR(45)       NOT NULL,
  publisher   VARCHAR(45)       NOT NULL,
  pages       SMALLINT UNSIGNED NOT NULL,
  quantity    SMALLINT UNSIGNED NOT NULL,
  description TEXT              NOT NULL,
  last_update TIMESTAMP         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  category_id TINYINT UNSIGNED  NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_book_category (category_id ASC),
  CONSTRAINT fk_book_category
  FOREIGN KEY (category_id)
  REFERENCES category (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  COMMENT = 'contains book details';


DROP TABLE IF EXISTS ordered_book;

CREATE TABLE IF NOT EXISTS ordered_book (
  id                INT UNSIGNED      NOT NULL AUTO_INCREMENT,
  customer_order_id INT UNSIGNED      NOT NULL,
  book_id           INT UNSIGNED      NOT NULL,
  quantity          SMALLINT UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY (id),
  INDEX fk_ordered_book_customer_order (customer_order_id ASC),
  INDEX fk_ordered_book_book (book_id ASC),
  CONSTRAINT fk_ordered_book_customer_order
  FOREIGN KEY (customer_order_id)
  REFERENCES customer_order (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ordered_book_book
  FOREIGN KEY (book_id)
  REFERENCES book (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  COMMENT = 'matches books with customer orders and records their quantity';
