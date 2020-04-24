package model;

import java.util.Arrays;
import java.util.Random;

public class GestiuneConcedii {

    private Concediu[] concedii;

    public GestiuneConcedii(Concediu[] concedii) {
        this.concedii = concedii;
        for (Concediu concediu : this.concedii) {
            concediu.calculareConcediu();
        }
    }

    //in functie de rating-ul de la CTO
    public void acordare(){
        for (Concediu concediu : concedii) {
            Random random = new Random();
            concediu.seAcorda = random.nextInt(10) <= concediu.angajat.ratingSuperior;
        }
    }

    @Override
    public String toString() {
        return "GestiuneConcedii{" +
                "concedii=" + Arrays.toString(concedii) +
                '}';
    }
}
