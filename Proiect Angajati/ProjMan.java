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

    public void adaugaInEchipa(SoftDev softdev){

        this.marimeEchipa = this.marimeEchipa + 1;
        SoftDev[] copie = new SoftDev[this.marimeEchipa];
        for (int i = 0; i < this.marimeEchipa - 1; i++){
            copie[i] = this.echipa[i];
        }
        copie[this.marimeEchipa - 1] = softdev;
        this.echipa = copie;
    }
}
