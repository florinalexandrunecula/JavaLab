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

    public void munceste(){

        if (this.munceste == true){
            System.out.println( "Angajatul munceste");
        }
        else {
            System.out.println("Angajatul nu munceste");
        }
    }
}