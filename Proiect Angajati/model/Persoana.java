package model;

import java.util.Random;

public class Persoana {

    private String nume;
    private String prenume;
    private int id;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        Random random = new Random();
        this.id = random.nextInt(10000);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", id=" + id +
                '}';
    }
}
