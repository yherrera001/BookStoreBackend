CREATE TABLE CATEGORY
(
    ID LONG PRIMARY KEY,
    TYPE VARCHAR(1000) NOT NULL
);


CREATE TABLE BOOKS
(
    ID LONG,
    DESCRIPTION VARCHAR(1000),
    PRICE LONG,
    IMAGE VARCHAR(1000),
    STATUS VARCHAR(1000),
    QUANTITY LONG,
    CATEGORY LONG NOT NULL,
    TITLE VARCHAR(1000) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (CATEGORY) REFERENCES CATEGORY(ID)
);
