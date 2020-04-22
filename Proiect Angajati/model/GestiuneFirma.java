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
        for (int i = 0; i < this.numarAngajati; i++){
            copie[i] = this.angajati[i];
        }
        copie[this.numarAngajati] = angajat;
        this.angajati = copie;
        this.numarAngajati = this.angajati.length;
    }

    public void daAfaraPeCineva(Angajat angajat){

        Angajat[] copie = new Angajat[this.numarAngajati - 1];
        int k = 0;
        for (int i = 0; i < this.angajati.length; i++){
            if (angajat.getNume().equals(this.angajati[i].getNume()) && angajat.getPrenume().equals(this.angajati[i].getPrenume())){
                continue;
            }
            copie[k] = this.angajati[i];
            k = k + 1;
        }
        this.angajati = copie;
        this.numarAngajati = this.angajati.length;

    }
}
