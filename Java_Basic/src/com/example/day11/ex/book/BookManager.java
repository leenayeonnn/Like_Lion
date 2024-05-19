package com.example.day11.ex.book;

import java.util.*;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if(books.contains(book)) {
            System.out.println("중복된 책 입니다.");
        } else {
            books.add(book);
            System.out.println("추가 완료");
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            book.display();
        }
    }

    public void sortBooksByYear() {
        Collections.sort(books);
        System.out.println("정렬 완료");
        displayBooks();
    }
}
