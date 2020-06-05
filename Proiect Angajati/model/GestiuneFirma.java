package model;

import java.util.Arrays;

public class GestiuneFirma {

    private String nume;
    private Angajat[] angajati;
    private int numarAngajati;

    public GestiuneFirma(String nume, Angajat[] angajati) {
        this.nume = nume;
        this.angajati = angajati;
        this.numarAngajati = this.angajati.length;
    }

    public Angajat[] getAngajati() {
        return angajati;
    }

    @Override
    public String toString() {
        return "GestiuneFirma{" +
                "nume='" + nume + '\'' +
                ", angajati=" + Arrays.toString(angajati) +
                ", numarAngajati=" + numarAngajati +
                '}';
    }

    public void angajeazaPeCineva(Angajat angajat){
        Angajat[] copie = new Angajat[this.numarAngajati + 1];
        if (this.numarAngajati >= 0) System.arraycopy(this.angajati, 0, copie, 0, this.numarAngajati);
        copie[this.numarAngajati] = angajat;
        this.angajati = copie;
        this.numarAngajati = this.angajati.length;
    }

    public void daAfaraPeCineva(Angajat angajat){
        Angajat[] copie = new Angajat[this.numarAngajati - 1];
        int k = 0;
        for (Angajat value : this.angajati) {
            if (angajat.getNume().equals(value.getNume()) && angajat.getPrenume().equals(value.getPrenume())) {
                continue;
            }
            copie[k] = value;
            k = k + 1;
        }
        this.angajati = copie;
        this.numarAngajati = this.angajati.length;

    }
}