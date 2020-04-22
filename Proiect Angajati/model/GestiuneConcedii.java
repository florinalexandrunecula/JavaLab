package model;

import java.util.Arrays;
import java.util.Random;

public class GestiuneConcedii {

    private Concediu[] concedii;

    public GestiuneConcedii(Concediu[] concedii) {

        this.concedii = concedii;
        for (int i = 0; i < this.concedii.length; i++){
            this.concedii[i].calculareConcediu();
        }
    }

    //in functie de rating-ul de la CTO
    public void acordare(){

        for (int i = 0; i < concedii.length; i++){
            Random random = new Random();
            if (random.nextInt(10) <= this.concedii[i].angajat.ratingSuperior){
                this.concedii[i].seAcorda = true;
            }
            else{
                this.concedii[i].seAcorda = false;
            }
        }
    }

    @Override
    public String toString() {

        return "GestiuneConcedii{" +
                "concedii=" + Arrays.toString(concedii) +
                '}';
    }
}
