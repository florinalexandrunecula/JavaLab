package imutabilitate;

public class Adresa {

    private String strada;
    private String nr;

    public Adresa(String strada, String nr) {
        this.strada = strada;
        this.nr = nr;
    }

    public Adresa(Adresa adresa) {
        this(adresa.getStrada(), adresa.getNr());
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "strada='" + strada + '\'' +
                ", nr='" + nr + '\'' +
                '}';
    }
}
