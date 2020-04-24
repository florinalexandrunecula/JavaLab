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
        setSalariuCalculat(baza * 2);
    }

    public void adaugaInEchipa(SoftDev softdev){
        this.marimeEchipa = this.marimeEchipa + 1;
        SoftDev[] copie = new SoftDev[this.marimeEchipa];
        if (this.marimeEchipa - 1 >= 0) System.arraycopy(this.echipa, 0, copie, 0, this.marimeEchipa - 1);
        copie[this.marimeEchipa - 1] = softdev;
        this.echipa = copie;
    }

    public void scotDinEchipa(SoftDev softdev){
        this.marimeEchipa = this.marimeEchipa - 1;
        SoftDev[] copie = new SoftDev[this.marimeEchipa];
        int k = 0;
        for (SoftDev softDev : this.echipa) {
            if (softdev.getNume().equals(softDev.getNume()) && softdev.getPrenume().equals(softDev.getPrenume())) {
                continue;
            }
            copie[k] = softDev;
            k = k + 1;
        }
        this.echipa = copie;
    }
}
