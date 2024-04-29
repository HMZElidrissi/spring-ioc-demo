package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresAvecAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ext", "metier");
        IMetier metier = context.getBean(IMetier.class);
        // IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Résultat = " + metier.calcul());
    }
}
