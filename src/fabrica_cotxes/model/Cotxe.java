package fabrica_cotxes.model;

public class Cotxe {

    public enum Carrosseria {HATCHBACK, SEDAN, FAMILIAR, COUPE}

    private String marca;
    private String model;
    private int any;
    private Carrosseria tipus;
    private Motor motor;
    private Xasis xasis;

    // Constructors
    public Cotxe(String marca, String model, int any, Carrosseria tipus, Motor motor, Xasis xasis) {
        this.marca = marca;
        this.model = model;
        this.any = any;
        this.tipus = tipus;
        this.motor = motor;
        this.xasis = xasis;
    }

    public Cotxe(String marca) {
        this.marca = marca;
        this.model = "Desconegut";
        this.any = 2023;
        this.tipus = Carrosseria.HATCHBACK;
        this.motor = new Motor();
        this.xasis = new Xasis();
    }

    public Cotxe(String marca, String model) {
        this.marca = marca;
        this.model = model;
        this.any = 2023;
        this.tipus = Carrosseria.HATCHBACK;
        this.motor = new Motor();
        this.xasis = new Xasis();
    }

    public Cotxe() {
        this("Desconeguda");
    }

    // Getters i setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Xasis getXasis() {
        return xasis;
    }

    public void setXasis(Xasis xasis) {
        this.xasis = xasis;
    }

    @Override
    //el toString es permet mostrar un objecte en format text. Si el sobreescrivim, és perquè decidim com mostrar el contingut
    public String toString() {
        return "Cotxe\nMarca: " + marca + "\nModel: " + model +
                "\nAny: " + any + "\nTipus: " + tipus +
                "\n" + motor + "\n" + xasis;
    }
}
