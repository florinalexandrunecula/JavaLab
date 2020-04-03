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
        CTO cto = CTO.createCTO("Bill", "Gates", 5, 1975, "Chief Technical Officer", angajati);
        System.out.println(cto.toString());
        SoftDev t3 = new SoftDev("Vasile", "Teodor", 2, 2015, "Software Developer", true);
        m1.adaugaInEchipa(t3);
        System.out.println(m1.toString());
    }
}
