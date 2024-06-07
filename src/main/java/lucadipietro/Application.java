package lucadipietro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucadipietro.dao.ElementoCatalogoDAO;
import lucadipietro.dao.PrestitoDAO;
import lucadipietro.dao.UtenteDAO;

public class Application {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        ElementoCatalogoDAO ed = new ElementoCatalogoDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);

//        Utente luca = new Utente("Luca", "Dipietro", LocalDate.of(1997, 10, 16));
//        Utente aldo = new Utente("Aldo", "Baglio", LocalDate.of(1958, 9, 28));
//        Utente giovanni = new Utente("Giovanni", "Storti", LocalDate.of(1957, 2, 20));
//        Utente giacomo = new Utente("Giacomo", "Poretti", LocalDate.of(1956, 4, 26));
//        ud.save(luca);
//        ud.save(aldo);
//        ud.save(giovanni);
//        ud.save(giacomo);

    }
}
