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
        setSalariuCalculat(baza * 3 + 44/100 * baza);
    }

    public void adaugaRating(){

        for (int i = 0; i < this.angajati.length; i++){
            Random random = new Random();
            if (this.angajati[i] instanceof SoftDev){
                SoftDev angajat = (SoftDev) this.angajati[i];
                if (angajat.munceste() == true){
                    this.angajati[i].ratingSuperior = random.nextInt(10);
                }
                else{
                    this.angajati[i].ratingSuperior = random.nextInt(5);
                }
            }
            else {
                this.angajati[i].ratingSuperior = random.nextInt(10);
            }
        }
    }

    public void adaugaInEchipa(Angajat angajat){

        Angajat[] copie = new Angajat[this.angajati.length + 1];
        for (int i = 0; i < this.angajati.length; i++){
            copie[i] = this.angajati[i];
        }
        copie[this.angajati.length] = angajat;
        this.angajati = copie;
    }

    public void scotDinEchipa(Angajat angajat){

        Angajat[] copie = new Angajat[this.angajati.length - 1];
        int k = 0;
        for (int i = 0; i < this.angajati.length; i++){
            if (angajat.getNume().equals(this.angajati[i].getNume()) && angajat.getPrenume().equals(this.angajati[i].getPrenume())){
                continue;
            }
            copie[k] = this.angajati[i];
            k = k + 1;
        }
        this.angajati = copie;
    }
}
