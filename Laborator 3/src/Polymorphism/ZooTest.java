package Polymorphism;

import Polymorphism.carnivor.Leu;
import Polymorphism.carnivor.Pisica;
import Polymorphism.ierbivor.Cal;
import Polymorphism.ierbivor.Elefant;
import Polymorphism.omnivor.Caine;
import Polymorphism.omnivor.Urs;

import java.util.Scanner;

//java.lang importat default

public class ZooTest {

    public static void main(String[] args) {

//        int nrAnimaleZoo = Integer.parseInt(args[0]);
//        System.out.println(nrAnimaleZoo);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Precizati nr maxim de animale ce pot fi gazduite la zoo: ");
//        int nrAnimaleZoo = scanner.nextInt();
//        scanner.close();
//
//        Zoo zooBucuresti = new Zoo(nrAnimaleZoo);
//        adaugaAnimalelaZoo(zooBucuresti);
//
//        for (int i = 0; i < zooBucuresti.animaleZoo.length && (zooBucuresti.animaleZoo[i] != null); i++){
//            Animal animal = zooBucuresti.animaleZoo[i];
//            animal.afiseazaDetalii();
//            animal.seHraneste();
//            animal.scoateSunet();
//        }

        Pisica pisica = new Pisica("Tom", 2);
        Pisica pisica1 = new Pisica("Tom", 2);
        System.out.println(pisica.equals(pisica1));
    }

    public static void adaugaAnimalelaZoo(Zoo zoo){

        Leu leu = new Leu("Simba", 7);
        zoo.adaugaAnimal(leu);
        Elefant elefant = new Elefant("Eli", 10);
        zoo.adaugaAnimal(elefant);
        Urs urs = new Urs("Fram", 4);
        zoo.adaugaAnimal(urs);
        Pisica pisica = new Pisica("Tom", 2);
        zoo.adaugaAnimal(pisica);
        Caine caine = new Caine("Toto", 3);
        zoo.adaugaAnimal(caine);
        Cal cal = new Cal("Thunder", 3);
        zoo.adaugaAnimal(cal);
    }
}
