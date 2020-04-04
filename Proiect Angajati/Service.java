import java.util.Arrays;

public class Service {

    public GestiuneFirma CreeazaOFirma(String nume, Angajat[] angajati){

        GestiuneFirma gestiune = new GestiuneFirma(nume, angajati);
        return gestiune;
    }

    public void AdaugaAngajat(GestiuneFirma gestiune, Angajat angajat){

        gestiune.angajeazaPeCineva(angajat);
    }

    public void Concediaza(GestiuneFirma gestiune, Angajat angajat){

        gestiune.daAfaraPeCineva(angajat);
    }

    public void CalculeazaSalarii(GestiuneFirma gestiune){

        Angajat[] angajati = gestiune.getAngajati();
        for (int i = 0; i < angajati.length; i++){
            angajati[i].calculareSalariu();
        }
    }

    public void AdaugaInEchipa(ProjMan projman, SoftDev softdev){

        projman.adaugaInEchipa(softdev);
    }

    public void ScotDinEchipa(ProjMan projman, SoftDev softdev){

        projman.scotDinEchipa(softdev);
    }

    public void AdaugListaCTO(CTO cto, Angajat angajat){

        cto.adaugaInEchipa(angajat);
    }

    public void ScotListaCTO(CTO cto, Angajat angajat){

        cto.scotDinEchipa(angajat);
    }

    public void AdaugRatingCTO(CTO cto){

        cto.adaugaRating();
    }

    public GestiuneConcedii CreeazaConcedii(Concediu[] concedii){

        GestiuneConcedii gestiune = new GestiuneConcedii(concedii);
        return gestiune;
    }

    public void AcordaConcedii(GestiuneConcedii gestiune){

        gestiune.acordare();
    }

    public void SorteazaConcedii(Concediu[] concedii){

        Arrays.sort(concedii, new SortByDays());
    }

    public void AfisareFirma(GestiuneFirma gestiune){

        System.out.println(gestiune.toString());
    }

    public void AfisareConcedii(GestiuneConcedii gestiune){

        System.out.println(gestiune.toString());
    }

    public void AfisareProiect(ProjMan projman){

        System.out.println(projman.toString());
    }
}
