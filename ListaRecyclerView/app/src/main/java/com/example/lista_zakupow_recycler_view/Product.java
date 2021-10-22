package com.example.lista_zakupow_recycler_view;

public class Product {
    private String nazwa;
    private boolean zaznaczony;

    public void setZaznaczony(boolean zaznaczony) {
        this.zaznaczony = zaznaczony;
    }

    public String getNazwa() {
        return nazwa;
    }

    public boolean isZaznaczony() {
        return zaznaczony;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public Product(String nazwa) {
        this.nazwa = nazwa;
        this.zaznaczony=false;
    }
}
