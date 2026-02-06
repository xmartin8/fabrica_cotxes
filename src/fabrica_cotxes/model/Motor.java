package fabrica_cotxes.model;

public class Motor {
    private int cilindrada;
    private int cavalls;
    private String combustible;
    private boolean eco; // 🔹 nou atribut

    public Motor(int cilindrada, int cavalls, String combustible, boolean eco) {
        this.cilindrada = cilindrada;
        this.cavalls = cavalls;
        this.combustible = combustible;
        this.eco = eco;
    }

    public Motor(int cilindrada) {
        this.cilindrada = cilindrada;
        this.cavalls = 100;
        this.combustible = "Gasolina";
        this.eco = false;
    }

    public Motor() {
        this.cilindrada = 1600;
        this.cavalls = 120;
        this.combustible = "Gasolina";
        this.eco = false;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCavalls() {
        return cavalls;
    }

    public void setCavalls(int cavalls) {
        this.cavalls = cavalls;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public boolean isEco() {
        return eco;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
    }

    @Override
    public String toString() {
        return "Motor [cilindrada=" + cilindrada +
                ", cavalls=" + cavalls +
                ", combustible=" + combustible +
                ", eco=" + eco + "]";
    }
}
