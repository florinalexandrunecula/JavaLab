import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        SoftDev t1 = new SoftDev("Alex", "Necula", 2, 2018, "Software Developer", true);
        t1.calculareSalariu();
        SoftDev t2 = new SoftDev("Bianca", "Buzoi", 1, 2019, "Software Developer", true);
        t2.calculareSalariu();
        SoftDev[] devel = new SoftDev[]{t1, t2};
        ProjMan m1 = new ProjMan("Popescu", "Ion", 5, 2000, "Project Manager", "Athena", 2, devel);
        m1.calculareSalariu();
        System.out.println(m1.toString());
        Angajat[] angajati = new Angajat[]{t1, t2, m1};
        SoftDev t3 = new SoftDev("Vasile", "Teodor", 2, 2015, "Software Developer", true);
        m1.adaugaInEchipa(t3);
        System.out.println(m1.toString());
        m1.scotDinEchipa(t1);
        System.out.println(m1.toString());
        CTO cto = CTO.createCTO("Bill", "Gates", 5, 1975, "Chief Technical Officer", angajati);
        cto.calculareSalariu();
        cto.adaugaRating();
        System.out.println(cto.toString());
        Concediu c1 = new Concediu(m1);
        Concediu c2 = new Concediu(t2);
        Concediu c3 = new Concediu(t1);
        Concediu[] concedii = new Concediu[]{c1, c2, c3};
        GestiuneConcedii gestiune = new GestiuneConcedii(concedii);
        gestiune.acordare();
        for (int i = 0; i < concedii.length; i++){
            System.out.println(concedii[i].toString());
        }
        Arrays.sort(concedii, new SortByDays());
        for (int i = 0; i < concedii.length; i++){
            System.out.println(concedii[i].toString());
        }
        Angajat[] ang = new Angajat[]{cto, t1, t2, m1};
        GestiuneFirma gestiunefirma = new GestiuneFirma("Microsoft", ang);
        System.out.println(gestiunefirma.toString());
        gestiunefirma.angajeazaPeCineva(t3);
        System.out.println(gestiunefirma.toString());
        gestiunefirma.daAfaraPeCineva(cto);
        System.out.println(gestiunefirma.toString());
    }
}
