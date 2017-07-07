package com.wefine;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
