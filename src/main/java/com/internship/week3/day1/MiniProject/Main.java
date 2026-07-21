package com.internship.week3.day1.MiniProject;

public class Main {

    public static void main(String args[]) {

        Repository<Book> books = new Repository<>();
        Repository<Member> members = new Repository<>();

        books.save(new Book(1, "book1"));
        books.save(new Book(2, "book2"));
        books.save(new Book(3, "book3"));
        books.save(new Book(4, "book4"));

        members.save(new Member(1, "Kamran"));
        members.save(new Member(2, "Ali"));

        books.delete(2);
        System.out.println(books.findAll());
        System.out.println(books.findById(4));
        System.out.println(members.findById(2));

    }
}
