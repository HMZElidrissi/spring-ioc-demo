package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpringXML {
    public static void main(String[] args) {
        // L'injection des dépendances d'une manière dynamique
        // ApplicationContext is an interface for Spring IoC container, it represents the container and is responsible to instantiate, configure, and assemble the objects.
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // Récupérer un bean en utilisant son id
        // IMetier metier = (IMetier) context.getBean("metier");
        // Récupérer un bean en utilisant l'interface
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
    }
}
