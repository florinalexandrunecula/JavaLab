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
        String[][] CompanyNames = Cititorul.readContent("CompanyNames.csv");
        String[][] CTOs = Cititorul.readContent("CTOs.csv");
        String[][] ProjectManagers = Cititorul.readContent("ProjectManagers.csv");
        String[][] SoftDevs = Cititorul.readContent("SoftDevs.csv");

        ServiciuAngajati S1 = new ServiciuAngajati();
        ServiciuGestiuneConcedii S2 = new ServiciuGestiuneConcedii();
        ServiciuGestiuneFirma S3 = new ServiciuGestiuneFirma();

        //Hai sa facem prima noastra firma. Avem nevoie de angajati si un CTO
        SoftDev s1 = new SoftDev(SoftDevs[0][0], SoftDevs[0][1], Integer.parseInt(SoftDevs[0][2]), Integer.parseInt(SoftDevs[0][3]), SoftDevs[0][4], Boolean.parseBoolean(SoftDevs[0][5]));
        SoftDev s2 = new SoftDev(SoftDevs[1][0], SoftDevs[1][1], Integer.parseInt(SoftDevs[1][2]), Integer.parseInt(SoftDevs[1][3]), SoftDevs[1][4], Boolean.parseBoolean(SoftDevs[1][5]));
        SoftDev[] echipa1 = new SoftDev[]{s1, s2};
        ProjMan p1 = new ProjMan(ProjectManagers[0][0], ProjectManagers[0][1], Integer.parseInt(ProjectManagers[0][2]), Integer.parseInt(ProjectManagers[0][3]), ProjectManagers[0][4], ProjectManagers[0][5], 2, echipa1);
        Angajat[] subordonati = new Angajat[]{s1, s2, p1};
        CTO cto = CTO.createCTO(CTOs[0][0], CTOs[0][1], Integer.parseInt(CTOs[0][2]), Integer.parseInt(CTOs[0][3]), CTOs[0][4], subordonati);
        Angajat[] angajati = new Angajat[]{s1, s2, p1, cto};
        GestiuneFirma MyCompany = S3.creeazaOFirma(CompanyNames[0][0], angajati);

        //Hai sa vedem cum arata firma noastra
        S3.afisareFirma(MyCompany);

        //Se pare ca nu avem salariile calculate, hai sa le calculam
        S3.calculeazaSalarii(MyCompany);
        S3.afisareFirma(MyCompany);

        //Se pare ca multi angajati vor sa vina la noi la firma, hai sa ii angajam
        SoftDev s3 = new SoftDev(SoftDevs[2][0], SoftDevs[2][1], Integer.parseInt(SoftDevs[2][2]), Integer.parseInt(SoftDevs[2][3]), SoftDevs[2][4], Boolean.parseBoolean(SoftDevs[2][5]));
        SoftDev s4 = new SoftDev(SoftDevs[3][0], SoftDevs[3][1], Integer.parseInt(SoftDevs[3][2]), Integer.parseInt(SoftDevs[3][3]), SoftDevs[3][4], Boolean.parseBoolean(SoftDevs[3][5]));
        SoftDev s5 = new SoftDev(SoftDevs[4][0], SoftDevs[4][1], Integer.parseInt(SoftDevs[4][2]), Integer.parseInt(SoftDevs[4][3]), SoftDevs[4][4], Boolean.parseBoolean(SoftDevs[4][5]));
        SoftDev[] echipa2 = new SoftDev[0];
        ProjMan p2 = new ProjMan(ProjectManagers[1][0], ProjectManagers[1][1], Integer.parseInt(ProjectManagers[1][2]), Integer.parseInt(ProjectManagers[1][3]), ProjectManagers[1][4], ProjectManagers[1][5], 0, echipa2);
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
