package serviciu.gestiuneFirma;
import model.*;
import util.Writer;

import java.io.IOException;
import java.util.Arrays;

public class ServiciuGestiuneFirma {

    private static Writer scriitorul = Writer.getInstance();

    public GestiuneFirma creeazaOFirma(String nume, Angajat[] angajati) throws IOException {
        GestiuneFirma gestiune = new GestiuneFirma(nume, angajati);
        scriitorul.writeContent("creeazaOFirma - " + Arrays.deepToString(angajati));
        return gestiune;
    }

    public void calculeazaSalarii(GestiuneFirma gestiune) throws IOException {
        Angajat[] angajati = gestiune.getAngajati();
        for (Angajat angajat : angajati) {
            angajat.calculareSalariu();
        }
        scriitorul.writeContent("calculeazaSalarii");
    }

    public void afisareFirma(GestiuneFirma gestiune) throws IOException {
        System.out.println(gestiune.toString());
        scriitorul.writeContent("afisareFirma");
    }
}
