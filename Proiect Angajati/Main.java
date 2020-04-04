public class Main {

    public static void main(String[] args) {

        Service MyService = new Service();

        //Hai sa facem prima noastra firma. Avem nevoie de angajati si un CTO
        SoftDev s1 = new SoftDev("Necula", "Alexandru", 2, 2018, "Software Developer", false);
        SoftDev s2 = new SoftDev("Buzoi", "Bianca", 1, 2019, "Software Developer", true);
        SoftDev[] echipa1 = new SoftDev[]{s1, s2};
        ProjMan p1 = new ProjMan("Gavril", "Bogdan", 3, 2017, "Project Manager", "MachineLearning", 2, echipa1);
        Angajat[] subordonati = new Angajat[]{s1, s2, p1};
        CTO cto = CTO.createCTO("Cook", "Tim", 30, 1975, "Chief Technical Officer", subordonati);
        Angajat[] angajati = new Angajat[]{s1, s2, p1, cto};
        GestiuneFirma MyCompany = MyService.CreeazaOFirma("Apple", angajati);

        //Hai sa vedem cum arata firma noastra
        MyService.AfisareFirma(MyCompany);

        //Se pare ca nu avem salariile calculate, hai sa le calculam
        MyService.CalculeazaSalarii(MyCompany);
        MyService.AfisareFirma(MyCompany);

        //Se pare ca multi angajati vor sa vina la noi la firma, hai sa ii angajam
        SoftDev s3 = new SoftDev("Popescu", "Alexandra", 4, 2020, "Software Developer", true);
        SoftDev s4 = new SoftDev("Brebeanu", "Andrei", 1, 2020, "Software Developer", false);
        SoftDev s5 = new SoftDev("Dumitrescu", "Liviu", 3, 2020, "Software Developer", true);
        SoftDev[] echipa2 = new SoftDev[0];
        ProjMan p2 = new ProjMan("Necula", "Gabriel", 10, 2020, "Project Manager", "DataGathering", 0, echipa2);
        MyService.AdaugaAngajat(MyCompany, s3);
        MyService.AdaugaAngajat(MyCompany, s4);
        MyService.AdaugaAngajat(MyCompany, s5);
        MyService.AdaugaAngajat(MyCompany, p2);
        MyService.AdaugListaCTO(cto, s3);
        MyService.AdaugListaCTO(cto, s4);
        MyService.AdaugListaCTO(cto, s5);
        MyService.AdaugListaCTO(cto, p2);
        MyService.CalculeazaSalarii(MyCompany);
        MyService.AfisareFirma(MyCompany);

        //Hmm...Alex Necula nu prea munceste...ar trebui concediat
        MyService.Concediaza(MyCompany, s1);
        MyService.ScotDinEchipa(p1, s1);
        MyService.ScotListaCTO(cto, s1);
        MyService.AfisareFirma(MyCompany);

        //Sa adaugam oameni in echipa de DataGathering
        MyService.AdaugaInEchipa(p2, s3);
        MyService.AdaugaInEchipa(p2, s4);
        MyService.AdaugaInEchipa(p2, s5);
        MyService.AfisareProiect(p2);

        //CTO-ul vrea sa le dea rating la angajatii lui, in functie de performanta lor
        MyService.AdaugRatingCTO(cto);

        //Fiecare angajat are dreptul la concediu, hai sa le calculam zilele de concediu
        Concediu c1 = new Concediu(s2);
        Concediu c2 = new Concediu(s3);
        Concediu c3 = new Concediu(s4);
        Concediu c4 = new Concediu(s5);
        Concediu c5 = new Concediu(p1);
        Concediu c6 = new Concediu(p2);
        Concediu c7 = new Concediu(cto);
        Concediu[] concedii = new Concediu[]{c1, c2, c3, c4, c5, c6, c7};
        GestiuneConcedii gestiuneConcedii = MyService.CreeazaConcedii(concedii);
        MyService.AcordaConcedii(gestiuneConcedii);
        MyService.SorteazaConcedii(concedii);
        MyService.AfisareConcedii(gestiuneConcedii);
    }
}
