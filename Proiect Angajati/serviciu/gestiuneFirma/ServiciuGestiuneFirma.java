package serviciu.gestiuneFirma;
import model.*;
import util.Writer;

import java.io.IOException;

public class ServiciuGestiuneFirma {

    private static Writer scriitorul = Writer.getInstance();

    public GestiuneFirma creeazaOFirma(String nume, Angajat[] angajati) throws IOException {

        GestiuneFirma gestiune = new GestiuneFirma(nume, angajati);
        scriitorul.writeContent("creeazaOFirma");
        return gestiune;
    }

    public void calculeazaSalarii(GestiuneFirma gestiune) throws IOException {

        Angajat[] angajati = gestiune.getAngajati();
        for (int i = 0; i < angajati.length; i++){
            angajati[i].calculareSalariu();
        }
        scriitorul.writeContent("calculeazaSalarii");
    }

    public void afisareFirma(GestiuneFirma gestiune) throws IOException {

        System.out.println(gestiune.toString());
        scriitorul.writeContent("afisareFirma");
    }
}
