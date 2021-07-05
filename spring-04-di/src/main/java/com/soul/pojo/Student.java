package com.soul.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbys;
    private Map<String, String> card;
    private Set<String> games;
    private String wife;
    private Properties info;

    public Student() {
    }

    public Student(String name, Address address, String[] books, List<String> hobbys, Map<String, String> card, Set<String> games, String wife, Properties info) {
        this.name = name;
        this.address = address;
        this.books = books;
        this.hobbys = hobbys;
        this.card = card;
        this.games = games;
        this.wife = wife;
        this.info = info;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public void setGames(Set<String> games) {
        this.games = games;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public void show() {
        System.out.println("name=" + name
                + ",address=" + address.getAddress()
                + ",books="
        );
        for (String book : books) {
            System.out.print("<<" + book + ">>\t");
        }

        System.out.println("\n爱好:" + hobbys);
        System.out.println("card:" + card);
        System.out.println("games:" + games);
        System.out.println("wife:" + wife);
        System.out.println("info:" + info);
    }
}
