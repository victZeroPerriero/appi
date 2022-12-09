package com.user.appi.listjanr;


public enum ListJanrBook {

    FILED1("1","Documental"),
    FILED2("2","Roman"),
    FIELD3("3","History"),
    FILED4("4","Programing"),
    FILED5("5","Science");
    private String janr;
    private String number;

    ListJanrBook(String janr, String number) {
        this.janr = janr;
        this.number = number;
    }

    public String getJanr() {
        return janr;
    }

    public String getNumber() {
        return number;
    }
}
