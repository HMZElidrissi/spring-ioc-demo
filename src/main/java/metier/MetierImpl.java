package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * L'annotation @Component permet de déclarer une classe comme un bean Spring.
 */
@Component("metier")
public class MetierImpl implements IMetier {
    /**
     * L'annotation @Autowired permet de demander à Spring d'injecter une dépendance.
     */
    // @Autowired
    private IDao dao;

    // Injection de dépendance par constructeur
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    /*public MetierImpl() {
    }*/

    @Override
    public double calcul() {
        double data = dao.getData();
        double result = data * 23;
        return result;
    }

    // Injection de dépendance par setter
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
