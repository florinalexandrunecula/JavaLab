package mainApp;

import serviciu.angajati.ServiciuAngajati;
import serviciu.gestiuneConcedii.ServiciuGestiuneConcedii;
import serviciu.gestiuneFirma.ServiciuGestiuneFirma;
import model.*;
import util.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader Cititorul = Reader.getInstance();
        String[][] values = Cititorul.readContent();

        ServiciuAngajati S1 = new ServiciuAngajati();
        ServiciuGestiuneConcedii S2 = new ServiciuGestiuneConcedii();
        ServiciuGestiuneFirma S3 = new ServiciuGestiuneFirma();

        //Hai sa facem prima noastra firma. Avem nevoie de angajati si un CTO
//        SoftDev s1 = new SoftDev("Necula", "Alexandru", 2, 2018, "Software Developer", false);
        SoftDev s1 = new SoftDev(values[1][0], values[1][1], Integer.parseInt(values[1][2]), Integer.parseInt(values[1][3]), values[1][4], Boolean.parseBoolean(values[1][5]));
//        SoftDev s2 = new SoftDev("Buzoi", "Bianca", 1, 2019, "Software Developer", true);
        SoftDev s2 = new SoftDev(values[2][0], values[2][1], Integer.parseInt(values[2][2]), Integer.parseInt(values[2][3]), values[2][4], Boolean.parseBoolean(values[2][5]));
        SoftDev[] echipa1 = new SoftDev[]{s1, s2};
//        ProjMan p1 = new ProjMan("Gavril", "Bogdan", 3, 2017, "Project Manager", "MachineLearning", 2, echipa1);
        ProjMan p1 = new ProjMan(values[3][0], values[3][1], Integer.parseInt(values[3][2]), Integer.parseInt(values[3][3]), values[3][4], values[3][5], 2, echipa1);
        Angajat[] subordonati = new Angajat[]{s1, s2, p1};
//        CTO cto = CTO.createCTO("Cook", "Tim", 30, 1975, "Chief Technical Officer", subordonati);
        CTO cto = CTO.createCTO(values[4][0], values[4][1], Integer.parseInt(values[4][2]), Integer.parseInt(values[4][3]), values[4][4], subordonati);
        Angajat[] angajati = new Angajat[]{s1, s2, p1, cto};
        GestiuneFirma MyCompany = S3.creeazaOFirma(values[0][0], angajati);

        //Hai sa vedem cum arata firma noastra
        S3.afisareFirma(MyCompany);

        //Se pare ca nu avem salariile calculate, hai sa le calculam
        S3.calculeazaSalarii(MyCompany);
        S3.afisareFirma(MyCompany);

        //Se pare ca multi angajati vor sa vina la noi la firma, hai sa ii angajam
//        SoftDev s3 = new SoftDev("Popescu", "Alexandra", 4, 2020, "Software Developer", true);
        SoftDev s3 = new SoftDev(values[5][0], values[5][1], Integer.parseInt(values[5][2]), Integer.parseInt(values[5][3]), values[5][4], Boolean.parseBoolean(values[5][5]));
//        SoftDev s4 = new SoftDev("Brebeanu", "Andrei", 1, 2020, "Software Developer", false);
        SoftDev s4 = new SoftDev(values[6][0], values[6][1], Integer.parseInt(values[6][2]), Integer.parseInt(values[6][3]), values[6][4], Boolean.parseBoolean(values[6][5]));
//        SoftDev s5 = new SoftDev("Dumitrescu", "Liviu", 3, 2020, "Software Developer", true);
        SoftDev s5 = new SoftDev(values[7][0], values[7][1], Integer.parseInt(values[7][2]), Integer.parseInt(values[7][3]), values[7][4], Boolean.parseBoolean(values[7][5]));
        SoftDev[] echipa2 = new SoftDev[0];
//        ProjMan p2 = new ProjMan("Necula", "Gabriel", 10, 2020, "Project Manager", "DataGathering", 0, echipa2);
        ProjMan p2 = new ProjMan(values[8][0], values[8][1], Integer.parseInt(values[8][2]), Integer.parseInt(values[8][3]), values[8][4], values[8][5], 0, echipa2);
        S1.adaugaAngajat(MyCompany, s3);
        S1.adaugaAngajat(MyCompany, s4);
        S1.adaugaAngajat(MyCompany, s5);
        S1.adaugaAngajat(MyCompany, p2);
        S1.adaugListaCTO(cto, s3);
        S1.adaugListaCTO(cto, s4);
        S1.adaugListaCTO(cto, s5);
        S1.adaugListaCTO(cto, p2);
        S3.calculeazaSalarii(MyCompany);
        S3.afisareFirma(MyCompany);

        //Hmm...Alex Necula nu prea munceste...ar trebui concediat
        S1.concediaza(MyCompany, s1);
        S1.scotDinEchipa(p1, s1);
        S1.scotListaCTO(cto, s1);
        S3.afisareFirma(MyCompany);

        //Sa adaugam oameni in echipa de DataGathering
        S1.adaugaInEchipa(p2, s3);
        S1.adaugaInEchipa(p2, s4);
        S1.adaugaInEchipa(p2, s5);
        S1.afisareProiect(p2);

        //CTO-ul vrea sa le dea rating la angajatii lui, in functie de performanta lor
        S1.adaugRatingCTO(cto);

        //Fiecare angajat are dreptul la concediu, hai sa le calculam zilele de concediu
        Concediu c1 = new Concediu(s2);
        Concediu c2 = new Concediu(s3);
        Concediu c3 = new Concediu(s4);
        Concediu c4 = new Concediu(s5);
        Concediu c5 = new Concediu(p1);
        Concediu c6 = new Concediu(p2);
        Concediu c7 = new Concediu(cto);
        Concediu[] concedii = new Concediu[]{c1, c2, c3, c4, c5, c6, c7};
        GestiuneConcedii gestiuneConcedii = S2.creeazaConcedii(concedii);
        S2.acordaConcedii(gestiuneConcedii);
        S2.sorteazaConcedii(concedii);
        S2.afisareConcedii(gestiuneConcedii);
    }
}
