package fabrica_cotxes.model;

public class Xasis {
    private String material;
    private int pes;

    public Xasis(String material, int pes) {
        this.material = material;
        this.pes = pes;
    }

    public Xasis(String material) {
        this.material = material;
        this.pes = 1200;
    }

    public Xasis() {
        this.material = "Acer";
        this.pes = 1000;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public int getPes() { return pes; }
    public void setPes(int pes) { this.pes = pes; }

    public void afegirPes(int pesExtra) { this.pes += pesExtra; }

    @Override
    public String toString() {
        return "Xasis [material=" + material + ", pes=" + pes + " kg]";
    }
}
