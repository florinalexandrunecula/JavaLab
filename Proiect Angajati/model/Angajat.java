package model;

public abstract class Angajat extends Persoana {

    private int vechime;
    private int anAngajare;
    private int salariuCalculat;
    private static int salariuBaza = 5000;
    private String post; // Software Developer, Project Manager, Chief Technical Officer
    protected int ratingSuperior;

    public Angajat(String nume, String prenume, int vechime, int anAngajare, String post) {

        super(nume, prenume);
        this.vechime = vechime;
        this.anAngajare = anAngajare;
        this.post = post;
    }

    public static int getSalariuBaza() {
        return salariuBaza;
    }

    public static void setSalariuBaza(int salariuBaza) {
        Angajat.salariuBaza = salariuBaza;
    }

    public int getVechime() {

        return vechime;
    }

    public void setVechime(int vechime) {

        this.vechime = vechime;
    }

    public int getAnAngajare() {

        return anAngajare;
    }

    public void setAnAngajare(int anAngajare) {

        this.anAngajare = anAngajare;
    }

    public int getSalariuCalculat() {

        return salariuCalculat;
    }

    public void setSalariuCalculat(int salariuCalculat) {

        this.salariuCalculat = salariuCalculat;
    }

    public String getPost() {

        return post;
    }

    public void setPost(String post) {

        this.post = post;
    }

    @Override
    public String toString() {

        return super.toString() + "Angajat{" +
                "vechime=" + vechime +
                ", anAngajare=" + anAngajare +
                ", salariuCalculat=" + salariuCalculat +
                ", post='" + post + '\'' +
                '}';
    }

//    public void calculareSalariu(){
//
//        if (this.post.equals("Software Developer")){
//            this.salariuCalculat = salariuBaza * 1 + 44/100 * salariuBaza;
//        }
//
//        if (this.post.equals("Project Manager")){
//            this.salariuCalculat = salariuBaza * 2 + 44/100 * salariuBaza;
//        }
//
//        if (this.post.equals("Chief Technical Officer")){
//            this.salariuCalculat = salariuBaza * 3 + 44/100 * salariuBaza;
//        }
//    }

    public abstract void calculareSalariu();

    public void marireSalariu(int procentaj){

        this.salariuCalculat = this.salariuCalculat + procentaj/100 * this.salariuCalculat;
    }
}
