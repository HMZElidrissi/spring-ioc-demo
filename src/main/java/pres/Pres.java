package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class Pres {
    public static void main(String[] args) {
        // L'injection des dépendances d'une manière statique
        DaoImpl dao = new DaoImpl();
        // MetierImpl metier = new MetierImpl();
        // metier.setDao(dao); // Injection de dépendance par setter
        // Injection de dépendance par constructeur
        MetierImpl metier = new MetierImpl(dao);
        System.out.println("Résultat = " + metier.calcul());
    }
}
