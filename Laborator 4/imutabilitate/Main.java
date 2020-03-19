package imutabilitate;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Adresa domiciliu = new Adresa("Timisoara", "4A");
        Persoana persoana = new Persoana(1, "Teo", domiciliu);
        String numePersoana = persoana.getNume().toUpperCase();
        System.out.println(persoana);
        System.out.println(numePersoana);

        String stradaUpperCase = domiciliu.getStrada().toUpperCase();
        domiciliu.setStrada(stradaUpperCase);
        System.out.println(persoana);

        Adresa adresaDomiciliu = persoana.getAdresa();
        String strada = adresaDomiciliu.getStrada();
        adresaDomiciliu.setStrada(strada.toUpperCase());

        System.out.println(persoana);
    }
}
