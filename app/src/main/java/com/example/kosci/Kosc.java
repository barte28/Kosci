package com.example.kosci;

public class Kosc {
    private int wartosc;
    private int idObrazka;
    private int[] idObrazkowKosci = {R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6};

    public void wylosujKosc() {
        wartosc = (int) (Math.random() * 6 + 1);
        idObrazka = idObrazkowKosci[wartosc - 1];
    }

    public Kosc() {
        wylosujKosc();
    }

    public int getWartosc() {
        return wartosc;
    }

    public int getIdObrazka() {
        return idObrazka;
    }
}