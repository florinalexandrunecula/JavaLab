package model;

import java.util.Arrays;
import java.util.Random;

public class CTO extends Angajat {

    private static CTO cto = null;
    public Angajat[] angajati;

    private CTO(String nume, String prenume, int vechime, int anAngajare, String post, Angajat[] angajati) {
        super(nume, prenume, vechime, anAngajare, post);
        this.angajati = angajati;
    }

    public static CTO createCTO(String nume, String prenume, int vechime, int anAngajare, String post, Angajat[] angajati){
        if (cto == null){
            cto = new CTO(nume, prenume, vechime, anAngajare, post, angajati);
        }
        return cto;
    }

    @Override
    public String toString() {
        return super.toString() + "CTO{" +
                "angajati=" + Arrays.toString(angajati) +
                '}';
    }

    @Override
    public void calculareSalariu() {
        int baza = getSalariuBaza();
        setSalariuCalculat(baza * 3);
    }

    public void adaugaRating(){
        for (Angajat value : this.angajati) {
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

    public void adaugaInEchipa(Angajat angajat){
        Angajat[] copie = new Angajat[this.angajati.length + 1];
        System.arraycopy(this.angajati, 0, copie, 0, this.angajati.length);
        copie[this.angajati.length] = angajat;
        this.angajati = copie;
    }

    public void scotDinEchipa(Angajat angajat){
        Angajat[] copie = new Angajat[this.angajati.length - 1];
        int k = 0;
        for (Angajat value : this.angajati) {
            if (angajat.getNume().equals(value.getNume()) && angajat.getPrenume().equals(value.getPrenume())) {
                continue;
            }
            copie[k] = value;
            k = k + 1;
        }
        this.angajati = copie;
    }
}
