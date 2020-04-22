package serviciu.gestiuneConcedii;

import java.io.IOException;
import java.util.Arrays;
import model.*;
import util.SortByDays;
import util.Writer;

public class ServiciuGestiuneConcedii {

    private static Writer scriitorul = Writer.getInstance();

    public GestiuneConcedii creeazaConcedii(Concediu[] concedii) throws IOException {

        GestiuneConcedii gestiune = new GestiuneConcedii(concedii);
        scriitorul.writeContent("creeazaConcedii");
        return gestiune;
    }

    public void acordaConcedii(GestiuneConcedii gestiune) throws IOException {

        gestiune.acordare();
        scriitorul.writeContent("acordaConcedii");
    }

    public void sorteazaConcedii(Concediu[] concedii) throws IOException {

        Arrays.sort(concedii, new SortByDays());
        scriitorul.writeContent("sorteazaConcedii");
    }

    public void afisareConcedii(GestiuneConcedii gestiune) throws IOException {

        System.out.println(gestiune.toString());
        scriitorul.writeContent("afisareConcedii");
    }
}
