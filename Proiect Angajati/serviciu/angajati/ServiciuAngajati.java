package serviciu.angajati;
import model.*;
import util.Writer;

import java.io.IOException;

public class ServiciuAngajati {

    private static Writer scriitorul = Writer.getInstance();

    public void adaugaAngajat(GestiuneFirma gestiune, Angajat angajat) throws IOException {
        gestiune.angajeazaPeCineva(angajat);
        scriitorul.writeContent("adaugaAngajat - " + angajat.toString());
    }

    public void concediaza(GestiuneFirma gestiune, Angajat angajat) throws IOException {
        gestiune.daAfaraPeCineva(angajat);
        scriitorul.writeContent("concediaza - " + angajat.toString());
    }

    public void adaugRatingCTO(CTO cto, Angajat[] angajati) throws IOException {
        cto.adaugaRating(angajati);
        scriitorul.writeContent("adaugRatingCTO");
    }

    public void afisareProiect(ProjMan projman) throws IOException {
        System.out.println(projman.toString());
        scriitorul.writeContent("afisareProiect - " + projman.toString());
    }
}
