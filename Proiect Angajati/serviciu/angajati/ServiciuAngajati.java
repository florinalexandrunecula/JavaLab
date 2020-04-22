package serviciu.angajati;
import model.*;
import util.Writer;

import java.io.IOException;

public class ServiciuAngajati {

    private static Writer scriitorul = Writer.getInstance();

    public void adaugaAngajat(GestiuneFirma gestiune, Angajat angajat) throws IOException {

        gestiune.angajeazaPeCineva(angajat);
        scriitorul.writeContent("adaugaAngajat");
    }

    public void concediaza(GestiuneFirma gestiune, Angajat angajat) throws IOException {

        gestiune.daAfaraPeCineva(angajat);
        scriitorul.writeContent("concediaza");
    }

    public void adaugaInEchipa(ProjMan projman, SoftDev softdev) throws IOException {

        projman.adaugaInEchipa(softdev);
        scriitorul.writeContent("adaugaInEchipa");
    }

    public void scotDinEchipa(ProjMan projman, SoftDev softdev) throws IOException {

        projman.scotDinEchipa(softdev);
        scriitorul.writeContent("scotDinEchipa");
    }

    public void adaugListaCTO(CTO cto, Angajat angajat) throws IOException {

        cto.adaugaInEchipa(angajat);
        scriitorul.writeContent("adaugListaCTO");
    }

    public void scotListaCTO(CTO cto, Angajat angajat) throws IOException {

        cto.scotDinEchipa(angajat);
        scriitorul.writeContent("scotListaCTO");
    }

    public void adaugRatingCTO(CTO cto) throws IOException {

        cto.adaugaRating();
        scriitorul.writeContent("adaugRatingCTO");
    }

    public void afisareProiect(ProjMan projman) throws IOException {

        System.out.println(projman.toString());
        scriitorul.writeContent("afisareProiect");
    }
}
