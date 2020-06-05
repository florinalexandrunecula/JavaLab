package model;

import java.util.Arrays;

public class ProjMan extends Angajat {

    private String proiect;

    public ProjMan(String nume, String prenume, int vechime, int anAngajare, String post, String proiect) {
        super(nume, prenume, vechime, anAngajare, post);
        this.proiect = proiect;
    }

    public String getProiect() {
        return proiect;
    }

    @Override
    public String toString() {
        return super.toString() + "ProjMan{" +
                "proiect='" + proiect + '\'' +
                '}';
    }

    @Override
    public void calculareSalariu() {
        int baza = getSalariuBaza();
        setSalariuCalculat(baza * 2);
    }
}
