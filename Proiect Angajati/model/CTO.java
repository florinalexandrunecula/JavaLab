package model;

import java.util.Arrays;
import java.util.Random;

public class CTO extends Angajat {

    private static CTO cto = null;

    private CTO(String nume, String prenume, int vechime, int anAngajare, String post) {
        super(nume, prenume, vechime, anAngajare, post);
    }

    public static CTO createCTO(String nume, String prenume, int vechime, int anAngajare, String post){
            if (cto == null){
            cto = new CTO(nume, prenume, vechime, anAngajare, post);
        }
        return cto;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void calculareSalariu() {
        int baza = getSalariuBaza();
        setSalariuCalculat(baza * 3);
    }

    public void adaugaRating(Angajat[] angajati){
        for (Angajat value : angajati) {
            Random random = new Random();
            if (value instanceof SoftDev) {
                SoftDev angajat = (SoftDev) value;
                if (angajat.munceste()) {
                    value.ratingSuperior = random.nextInt(10);
                } else {
                    value.ratingSuperior = random.nextInt(5);
                }
            } else {
                value.ratingSuperior = random.nextInt(10);
            }
        }
    }
}
