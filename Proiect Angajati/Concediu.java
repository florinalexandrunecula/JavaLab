public class Concediu {

    protected Angajat angajat;
    private int zileConcediu;
    protected boolean seAcorda;

    //calculam zilele de concediu in functie de vechime si functie

    public Concediu(Angajat angajat) {

        this.angajat = angajat;
    }

    public int getZileConcediu() {

        return zileConcediu;
    }

    public void calculareConcediu(){

        String post = angajat.getPost();
        int vechime = angajat.getVechime();
        if (post == "Software Developer"){
            int baza = 20;
            this.zileConcediu = baza + (vechime * baza)/2;
        }
        if (post == "Project Manager"){
            int baza = 25;
            this.zileConcediu = baza + (vechime * baza)/2;
        }
        if (post == "Chief Technical Officer"){
            int baza = 30;
            this.zileConcediu = baza + (vechime * baza)/2;
        }
    }

    @Override
    public String toString() {

        return "Concediu{" +
                "angajat=" + angajat +
                ", zileConcediu=" + zileConcediu +
                ", seAcorda=" + seAcorda +
                '}';
    }
}
