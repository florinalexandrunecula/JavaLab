package model;

public class SoftDev extends Angajat {

    private boolean munceste;

    public SoftDev(String nume, String prenume, int vechime, int anAngajare, String post, boolean munceste) {
        super(nume, prenume, vechime, anAngajare, post);
        this.munceste = munceste;
    }

    @Override
    public String toString() {
        return super.toString() + "SoftDev{" +
                "munceste=" + munceste +
                '}';
    }

    @Override
    public void calculareSalariu() {
        int baza = getSalariuBaza();
        setSalariuCalculat(baza);
    }

    public boolean munceste(){
        if (this.munceste){
            System.out.println( "Angajatul munceste");
            return true;
        }
        else {
            System.out.println("Angajatul nu munceste");
            return false;
        }
    }


}
