import java.util.Arrays;

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
}
