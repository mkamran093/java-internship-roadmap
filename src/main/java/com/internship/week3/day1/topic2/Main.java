package com.internship.week3.day1.topic2;

import com.internship.week2.day5.LibraryManagement.Book;
import com.internship.week2.day5.LibraryManagement.Member;

public class Main  {

    public static void main(String args[]) {

        Box<String> stringBox = new Box<>("Ali");
        Box<Integer> integerBox = new Box<>(0);
        Box<Book> bookBox = new Box<>(new Book("1234", "lsjl", 2));

        String str = stringBox.getValue();
        int integer = integerBox.getValue();
        Book book = bookBox.getValue();

        System.out.println(str);
        System.out.println(integer);
        System.out.println(book);

        Pair<Integer, String> intString = new Pair<>(1, "One");
        Pair<String, Book> stringBook = new Pair<>("101", new Book("124er23", "sjgslg", 3));
        Pair<Book, Member> bookMember = new Pair<>(new Book("1241f", "lsdjlj", 4), new Member("1-1", "Ali"));

        System.out.println(intString);
        System.out.println(stringBook);
        System.out.println(bookMember);

        String stringPairValue = intString.getValue();
        Book bookPairValue = stringBook.getValue();
        Member memberPairValue = bookMember.getValue();

        System.out.println("Values after retrieving without casting");
        System.out.println(stringPairValue);
        System.out.println(bookPairValue);
        System.out.println(memberPairValue);




    }
}
