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
}
