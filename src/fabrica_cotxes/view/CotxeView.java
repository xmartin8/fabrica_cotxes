package fabrica_cotxes.view;

import fabrica_cotxes.controller.CotxeController;
import fabrica_cotxes.model.Cotxe;
import java.util.Scanner;

public class CotxeView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CotxeController muntatge = new CotxeController();
        int opcio;

        do {
            System.out.println("\n--- CONCESSIONARI ---");
            System.out.println("1. Afegir cotxe");
            System.out.println("2. Llistar cotxes");
            System.out.println("3. Muntar motor");
            System.out.println("4. Muntar xasis");
            System.out.println("5. Mostrar cotxes ecològics");
            System.out.println("0. Sortir");
            System.out.print("Opció: ");
            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix la marca: ");
                    String marca = sc.nextLine();
                    muntatge.afegirCotxe(marca);
                    break;

                case 2:
                    System.out.println(muntatge.llistarCotxes());
                    break;

                case 3:
                    System.out.print("Índex cotxe: ");
                    int iMotor = sc.nextInt();
                    System.out.print("Cavalls: ");
                    int cv = sc.nextInt();
                    System.out.print("Cilindrada: ");
                    int cc = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Combustible: ");
                    String comb = sc.nextLine();
                    System.out.print("Eco (true/false): ");
                    boolean eco = sc.nextBoolean();
                    sc.nextLine();
                    muntatge.montarMotor(iMotor, cv, cc, comb, eco);
                    break;

                case 4:
                    System.out.print("Índex cotxe: ");
                    int iXasis = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Material del xasis: ");
                    String material = sc.nextLine();

                    System.out.print("Pes del xasis: ");
                    int pes = sc.nextInt();

                    muntatge.montarXasis(iXasis, material, pes);
                    break;


                case 5:
                    muntatge.filtrarCotxesEco();
                    Cotxe[] ecoArr = muntatge.getCotxesEco();
                    for (Cotxe c : ecoArr) mostrarEco(muntatge, c);
                    break;
            }

        } while (opcio != 0);

        System.out.println("Programa finalitzat.");
    }

    /**
     * Mostra un cotxe i si és ecològic
     */
    private static void mostrarEco(CotxeController controller, Cotxe cotxe) {
        boolean eco = controller.esEco(obtenirIndex(controller, cotxe));
        System.out.println("----- INFORMACIÓ DEL COTXE -----");
        System.out.println(cotxe);
        System.out.println(eco ? "Aquest cotxe és ecològic 🌱" : "Aquest cotxe NO és ecològic");
        System.out.println("-----------------------------");
    }

    /**
     * Obté l'índex d'un cotxe dins del controller
     */
    private static int obtenirIndex(CotxeController muntatge, Cotxe cotxe) {
        Cotxe[] tots = muntatge.getTotsCotxes();
        for (int i = 0; i < tots.length; i++) {
            if (tots[i] == cotxe) return i;
        }
        return -1;
    }
}
