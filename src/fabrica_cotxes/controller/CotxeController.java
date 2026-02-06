package fabrica_cotxes.controller;

import fabrica_cotxes.model.*;

public class CotxeController {

    private Cotxe[] cotxes = new Cotxe[10];
    private int numCotxes = 0;

    private Cotxe[] cotxesEco = new Cotxe[10];
    private int numEco = 0;

    public void afegirCotxe(String marca) {
        if (numCotxes < cotxes.length) {
            cotxes[numCotxes++] = new Cotxe(marca);
        }
    }

    public String llistarCotxes() {
        if (numCotxes == 0) return "No hi ha cotxes.";
        String resultat = "";
        for (int i = 0; i < numCotxes; i++) resultat += i + " - " + cotxes[i] + "\n";
        return resultat;
    }

    public void montarMotor(int index, int cavalls, int cilindrada, String combustible, boolean eco) {
        if (index >= 0 && index < numCotxes) {
            cotxes[index].setMotor(new Motor(cilindrada, cavalls, combustible, eco));
        }
    }

    public void montarXasis(int index, String material, int pes) {
        if (index >= 0 && index < numCotxes) {
            cotxes[index].setXasis(new Xasis(material, pes));
        }
    }


    /** Omple array amb cotxes ecològics segons regles */
    public void filtrarCotxesEco() {
        numEco = 0;
        for (int i = 0; i < numCotxes; i++) {
            if (esEco(i) && numEco < cotxesEco.length) {
                cotxesEco[numEco++] = cotxes[i];
            }
        }
    }

    public Cotxe[] getCotxesEco() {
        Cotxe[] res = new Cotxe[numEco];
        for (int i = 0; i < numEco; i++) res[i] = cotxesEco[i];
        return res;
    }

    /** Decideix si el cotxe és ecològic */
    public boolean esEco(int index) {
        if (index < 0 || index >= numCotxes) return false;
        Motor m = cotxes[index].getMotor();
        if (m == null) return false;

        if (m.isEco()) return true; // atribut eco

        // benzina/diesel i consum <= 5 litres
        if (m.getCombustible().equalsIgnoreCase("gasolina") ||
                m.getCombustible().equalsIgnoreCase("diesel")) {

            double mitja_consum = m.getCilindrada() / 1000.0 * 3; // exemple didàctic
            return mitja_consum <= 5;
        }

        return false;
    }

    /** Retorna tots els cotxes */
    public Cotxe[] getTotsCotxes() {
        Cotxe[] res = new Cotxe[numCotxes];
        for (int i = 0; i < numCotxes; i++) res[i] = cotxes[i];
        return res;
    }
}
