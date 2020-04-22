package model;

import java.util.Arrays;

public class ProjMan extends Angajat {

    private String proiect;
    private int marimeEchipa;
    private SoftDev[] echipa;

    public ProjMan(String nume, String prenume, int vechime, int anAngajare, String post, String proiect, int marimeEchipa, SoftDev[] echipa) {

        super(nume, prenume, vechime, anAngajare, post);
        this.proiect = proiect;
        this.marimeEchipa = marimeEchipa;
        this.echipa = echipa;
    }

    @Override
    public String toString() {

        return super.toString() + "ProjMan{" +
                "proiect='" + proiect + '\'' +
                ", marimeEchipa=" + marimeEchipa +
                ", echipa=" + Arrays.toString(echipa) +
                '}';
    }

    @Override
    public void calculareSalariu() {

        int baza = getSalariuBaza();
        setSalariuCalculat(baza * 2 + 44/100 * baza);
    }

    public void adaugaInEchipa(SoftDev softdev){

        this.marimeEchipa = this.marimeEchipa + 1;
        SoftDev[] copie = new SoftDev[this.marimeEchipa];
        for (int i = 0; i < this.marimeEchipa - 1; i++){
            copie[i] = this.echipa[i];
        }
        copie[this.marimeEchipa - 1] = softdev;
        this.echipa = copie;
    }

    public void scotDinEchipa(SoftDev softdev){

        this.marimeEchipa = this.marimeEchipa - 1;
        SoftDev[] copie = new SoftDev[this.marimeEchipa];
        int k = 0;
        for (int i = 0; i < this.echipa.length; i++){
            if (softdev.getNume().equals(this.echipa[i].getNume()) && softdev.getPrenume().equals(this.echipa[i].getPrenume())){
                continue;
            }
            copie[k] = this.echipa[i];
            k = k + 1;
        }
        this.echipa = copie;
    }
}
